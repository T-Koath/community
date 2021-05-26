package life.majiang.community.exception;

/**
 * @ClassName CustomizeException
 * @Description TODO
 * @date 2021/5/25 16:18
 * @Version 1.0
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;


    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
