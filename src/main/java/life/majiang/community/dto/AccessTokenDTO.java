package life.majiang.community.dto;

import lombok.Data;

/**
 * @ClassName AccesstokenDTO
 * @Description TODO
 * @date 2021/5/12 13:25
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
