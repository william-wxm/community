package life.weike.community.community.controller;

import life.weike.community.community.QuestionService.CommentService;
import life.weike.community.community.QuestionService.QuesionService;
import life.weike.community.community.dto.CommentCreateDTO;
import life.weike.community.community.dto.CommentDTO;
import life.weike.community.community.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionConntroller {
    @Autowired
    private QuesionService quesionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") Long id,
                           Model model){
        QuestionDTO questionDTO = quesionService.getById(id);
        List<CommentDTO> comments = commentService.listByQuestionId(id);
        //累加评论
        quesionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
