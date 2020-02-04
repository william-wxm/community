package life.weike.community.community.controller;
import life.weike.community.community.mapper.GithubUserMapper;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired
    private GithubUserMapper githubUserMapper;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
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
        return "index";
    }
}
