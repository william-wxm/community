package life.weike.community.community.controller;

import life.weike.community.community.QuestionService.CommentService;
import life.weike.community.community.dto.CommentDTO;
import life.weike.community.community.dto.ResultDTO;
import life.weike.community.community.mapper.CommentMapper;
import life.weike.community.community.model.Comment;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

@Autowired
private CommentService commentService;
    @PostMapping("/comment")
    @ResponseBody
    public Object post(CommentDTO commentDTO,
            HttpServletRequest request){
        User user =(User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(2002,"未登录，无法评论，请登录");
        }
        Comment comment = new Comment();
        comment.setParentId(comment.getParentId());
        comment.setComment(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setLikeCount(0L);
        comment.setCommentator(user.getId());
        commentService.insert(comment);
        Map<Object,Object> MHashMap = new HashMap<>();
        MHashMap.put("message","成功");
        return MHashMap;
    }
}
