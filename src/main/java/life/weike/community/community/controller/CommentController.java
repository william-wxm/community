package life.weike.community.community.controller;

import life.weike.community.community.Exception.CustomizeErrorCode;
import life.weike.community.community.QuestionService.CommentService;
import life.weike.community.community.dto.CommentCreateDTO;
import life.weike.community.community.dto.ResultDTO;
import life.weike.community.community.model.Comment;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/comment" , method = RequestMethod.POST)
    @ResponseBody
    public Object post( @RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentCreateDTO == null || commentCreateDTO.getContent() == null || commentCreateDTO.getContent() == ""){
            return ResultDTO.errorOf(CustomizeErrorCode.COMMENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setComment(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setLikeCount(0L);
        comment.setCommentator(user.getId());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
