package life.majiang.community.exception;

/**
 * 枚举类型
 * @ClassName CustomizeErrorCode
 * @Description TODO
 * @date 2021/5/25 16:32
 * @Version 1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    Question_Not_Found("你找的问题不存在!");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }


}
