package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.UploadResponseDTO;
import DairyWeb.dairy.DairyExceptions.BusinessException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
import java.util.UUID;

@Service
public class UploadService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service-key}")
    private String supabaseServiceKey;

    private static final String BUCKET_NAME = "dairy-images";

    // Maximum image size = 3 MB
    private static final long MAX_FILE_SIZE =
            3 * 1024 * 1024;

    private static final Set<String> ALLOWED_EXTENSIONS =
            Set.of(
                    "jpg",
                    "jpeg",
                    "png",
                    "webp"
            );

    public UploadResponseDTO upload(MultipartFile file) {

        // 1. Basic validation
        validateFile(file);

        // 2. Get extension from filename
        String extension = getExtension(file);

        // Normalize jpeg -> jpg
        if ("jpeg".equals(extension)) {
            extension = "jpg";
        }

        // 3. Generate unique filename
        String fileName =
                UUID.randomUUID() + "." + extension;

        // Example:
        // https://xxxxx.supabase.co/storage/v1/object/dairy-images/uuid.png

        String uploadUrl =
                supabaseUrl
                        + "/storage/v1/object/"
                        + BUCKET_NAME
                        + "/"
                        + fileName;

        // 4. Prepare headers
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(
                supabaseServiceKey
        );

        headers.set(
                "apikey",
                supabaseServiceKey
        );

        /*
         * IMPORTANT:
         *
         * Do NOT use:
         *
         * file.getContentType()
         *
         * because Postman / React Native may send:
         *
         * application/octet-stream
         *
         * Instead determine the correct MIME type
         * ourselves.
         */
        headers.setContentType(
                getMediaType(extension)
        );

        // Don't overwrite existing files
        headers.set(
                "x-upsert",
                "false"
        );

        try {

            byte[] fileBytes =
                    file.getBytes();

            HttpEntity<byte[]> request =
                    new HttpEntity<>(
                            fileBytes,
                            headers
                    );

            RestTemplate restTemplate =
                    new RestTemplate();

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            uploadUrl,
                            HttpMethod.POST,
                            request,
                            String.class
                    );

            if (!response
                    .getStatusCode()
                    .is2xxSuccessful()) {

                throw new BusinessException(
                        "Failed to upload image"
                );
            }

        } catch (BusinessException e) {

            throw e;

        } catch (Exception e) {

            throw new BusinessException(
                    "Failed to upload image: "
                            + e.getMessage()
            );
        }

        // 5. Generate public URL
        String publicUrl =
                supabaseUrl
                        + "/storage/v1/object/public/"
                        + BUCKET_NAME
                        + "/"
                        + fileName;

        // 6. Return URL
        return new UploadResponseDTO(
                publicUrl
        );
    }

    /**
     * Validate uploaded file.
     */
    private void validateFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {

            throw new BusinessException(
                    "File cannot be empty"
            );
        }

        if (file.getSize() > MAX_FILE_SIZE) {

            throw new BusinessException(
                    "File size cannot exceed 3 MB"
            );
        }

        String extension =
                getExtension(file);

        if (!ALLOWED_EXTENSIONS.contains(extension)) {

            throw new BusinessException(
                    "Only JPG, JPEG, PNG and WEBP images are allowed"
            );
        }
    }

    /**
     * Extract extension from original filename.
     *
     * Example:
     *
     * cow.png -> png
     * cow.JPG -> jpg
     */
    private String getExtension(
            MultipartFile file
    ) {

        String originalFilename =
                file.getOriginalFilename();

        if (originalFilename == null ||
                originalFilename.isBlank()) {

            throw new BusinessException(
                    "Invalid file name"
            );
        }

        int dotIndex =
                originalFilename.lastIndexOf(".");

        if (dotIndex == -1 ||
                dotIndex == originalFilename.length() - 1) {

            throw new BusinessException(
                    "File extension is missing"
            );
        }

        return originalFilename
                .substring(dotIndex + 1)
                .toLowerCase();
    }

    /**
     * Determine actual Content-Type sent to Supabase.
     */
    private MediaType getMediaType(
            String extension
    ) {

        return switch (extension.toLowerCase()) {

            case "jpg", "jpeg" ->
                    MediaType.IMAGE_JPEG;

            case "png" ->
                    MediaType.IMAGE_PNG;

            case "webp" ->
                    MediaType.parseMediaType(
                            "image/webp"
                    );

            default ->
                    throw new BusinessException(
                            "Unsupported image type"
                    );
        };
    }
}