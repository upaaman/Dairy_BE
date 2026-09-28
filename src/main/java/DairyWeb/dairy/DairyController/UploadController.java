package DairyWeb.dairy.DairyController;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.UploadResponseDTO;
import DairyWeb.dairy.DairyServices.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping
    public ResponseEntity<UploadResponseDTO> upload(
            @RequestParam("file") MultipartFile file
    ) {
                System.out.println(file+"aman file controlller"+file.getSize()+file.getName());
        return ResponseEntity.ok(
                uploadService.upload(file)
        );
    }
}