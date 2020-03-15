package life.weike.community.community.controller;

import life.weike.community.community.QuestionService.QuesionService;
import life.weike.community.community.dto.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;



@Controller
public class IndexController {

    @Autowired
    private QuesionService quesionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "8") Integer size) {

        PaginationDTO pagination = quesionService.list(page, size);
        model.addAttribute("questions", pagination);
        return "index";
    }
}
