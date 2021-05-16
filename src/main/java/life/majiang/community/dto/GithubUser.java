package life.majiang.community.dto;

import lombok.Data;

/**
 * @ClassName GithubUser
 * @Description TODO
 * @date 2021/5/12 14:07
 * @Version 1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
