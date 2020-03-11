package life.weike.community.community.QuestionService;

import life.weike.community.community.mapper.GithubUserMapper;
import life.weike.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private GithubUserMapper githubUserMapper;

    public void createOrUpdate(User user) {
        User dbUser = githubUserMapper.findByAccountId(user.getAccountId());
        if (dbUser == null) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            githubUserMapper.insert(user);
        } else {
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            githubUserMapper.update(dbUser);
        }
    }
}
