package life.weike.community.community.dto;

import life.weike.community.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private long id;
    private long parentId;
    private Integer type;
    private long commentator;
    private String comment;
    private long gmtCreate;
    private long gmtModified;
    private long likeCount;
    private User user;



}
