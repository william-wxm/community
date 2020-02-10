package life.weike.community.community.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String accountId;
    private Long gmtCreate;
    private Long gmtModified;
    private String token;
    private String avatarUrl;

}
