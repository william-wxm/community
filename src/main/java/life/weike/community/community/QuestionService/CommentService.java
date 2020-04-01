package life.weike.community.community.QuestionService;

import life.weike.community.community.Exception.CustomizeErrorCode;
import life.weike.community.community.Exception.CustomizeException;
import life.weike.community.community.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void insert(Comment comment) {
if(comment.getParentId()==null || comment.getParentId()==0){
    throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
}
    }
}
