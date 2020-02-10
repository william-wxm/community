package life.weike.community.community.model;

import lombok.Data;

@Data
public class Question {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Long commentCount;
    private Long viewCount;
    private Long likeCount;
    private String tag;
}
