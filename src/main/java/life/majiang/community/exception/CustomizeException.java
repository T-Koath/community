package life.majiang.community.exception;

/**
 * @ClassName CustomizeException
 * @Description TODO
 * @date 2021/5/25 16:18
 * @Version 1.0
 */
public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
