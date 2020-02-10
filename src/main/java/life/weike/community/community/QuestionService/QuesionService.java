package life.weike.community.community.QuestionService;
import life.weike.community.community.dto.QuestionDTO;
import life.weike.community.community.mapper.GithubUserMapper;
import life.weike.community.community.mapper.QuestionMapper;
import life.weike.community.community.model.Question;
import life.weike.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuesionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private GithubUserMapper githubUserMapper;

    public List<QuestionDTO> list(){
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions){
            User user = githubUserMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question , questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
