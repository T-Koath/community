package life.majiang.community.dto;

import lombok.Data;

/**
 * @ClassName CommentDTO
 * @Description TODO
 * @date 2021/5/26 11:24
 * @Version 1.0
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
