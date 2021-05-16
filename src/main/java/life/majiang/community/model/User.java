package life.majiang.community.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @date 2021/5/13 22:00
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
