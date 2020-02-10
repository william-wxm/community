package life.weike.community.community.dto;

import lombok.Data;

@Data
public class AccessTokenDTO {
    private String client_id;
    private String redirect_uri;
    private String code;
    private String state;
    private String client_secret;

}
