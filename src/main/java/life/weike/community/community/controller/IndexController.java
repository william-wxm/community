package life.weike.community.community.controller;
import life.weike.community.community.QuestionService.QuesionService;
import life.weike.community.community.dto.QuestionDTO;
import life.weike.community.community.mapper.GithubUserMapper;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private GithubUserMapper githubUserMapper;
    @Autowired
    private QuesionService quesionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model) {
        Cookie[] cookies = request.getCookies();
       if (cookies != null && cookies.length != 0){
           for (Cookie cookie : cookies){
               if (cookie.getName().equals("token")){
                   String token = cookie.getValue();
                   User user = githubUserMapper.findByToken(token);
                   if (user != null){
                       request.getSession().setAttribute("user" , user);
                   }
                   break;
               }
           }
       }
        List<QuestionDTO> questionList = quesionService.list();
       model.addAttribute("questions",questionList);
        return "index";
    }
}
