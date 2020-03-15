package life.weike.community.community.controller;

import life.weike.community.community.QuestionService.QuesionService;
import life.weike.community.community.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionConntroller {
    @Autowired
    private QuesionService quesionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") long id,
                           Model model){
        QuestionDTO questionDTO = quesionService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
