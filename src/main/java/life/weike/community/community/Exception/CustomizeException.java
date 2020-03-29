package life.weike.community.community.Exception;

public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode iCustomizeErrorCode) {
        this.message = iCustomizeErrorCode.getMessage();
    }

    public CustomizeException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
