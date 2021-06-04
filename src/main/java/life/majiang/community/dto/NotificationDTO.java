package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * @ClassName NotificationDTO
 * @Description TODO
 * @date 2021/6/4 16:13
 * @Version 1.0
 */
@Data
public class NotificationDTO {
    private Long id ;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerId;
    private String typeName;
    private Integer type;
}
