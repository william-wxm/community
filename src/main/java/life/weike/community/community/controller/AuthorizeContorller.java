package life.weike.community.community.controller;

import life.weike.community.community.GithubProvider.githubProvider;
import life.weike.community.community.dto.AccessTokenDTO;
import life.weike.community.community.dto.GithubUser;
import life.weike.community.community.mapper.GithubUserMapper;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeContorller {

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectURI;
    @Autowired
    private GithubUserMapper githubUserMapper;
    @Autowired
    private githubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code ,
                           @RequestParam (name="state")String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectURI);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null){
            User user = new User();
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setName(githubUser.getName());
            user.setToken(UUID.randomUUID().toString());
            githubUserMapper.insert(user);
            request.getSession().setAttribute("githubUser",githubUser);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
