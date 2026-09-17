package DairyWeb.dairy.DairyExceptions;

public class ErrorResponseDTO {
    private int status;

    public int getStatus() {
        return status;
    }

    public ErrorResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
