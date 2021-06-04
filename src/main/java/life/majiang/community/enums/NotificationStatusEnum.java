package life.majiang.community.enums;

/**
 * @ClassName NotificationEnum
 * @Description TODO
 * @date 2021/6/3 22:17
 * @Version 1.0
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);

    private int status;
    private String name;

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    NotificationStatusEnum(int type, String name) {
        this.status = type;
        this.name = name;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }


}
