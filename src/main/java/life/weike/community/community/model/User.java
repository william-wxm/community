package life.weike.community.community.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String accountId;
    private long gmtCreate;
    private long gmtModified;
    private String token;
    private String avatarUrl;

}
