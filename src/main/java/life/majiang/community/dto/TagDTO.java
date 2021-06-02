package life.majiang.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName TagDTO
 * @Description TODO
 * @date 2021/6/2 17:30
 * @Version 1.0
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
