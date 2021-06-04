package life.majiang.community.exception;

/**
 * 枚举类型
 * @ClassName CustomizeErrorCode
 * @Description TODO
 * @date 2021/5/25 16:32
 * @Version 1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    Question_Not_Found(2001,"你找的问题不存在!换个试试叭！"),
    TARGET_PARAM_Not_Found(2002,"未选中任何问题或评论进行回复!"),
    NO_LOGIN(2003,"当前操作需登录，请登录后重试!"),
    SYS_ERROR(2004,"服务器炸了，请稍后重试!"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在!"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，换个试试!"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空！"),
    READ_NOTIFICATION_FAIL(2008,"读取信息出错！"),
    NOTIFICATION_NOT_FOUND(2009,"消息不翼而飞了！"),
    ;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }




}
