package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * 传输层的类，封装Question与User类
 * @ClassName QuestionDTO
 * @Description TODO
 * @date 2021/5/17 15:41
 * @Version 1.0
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
