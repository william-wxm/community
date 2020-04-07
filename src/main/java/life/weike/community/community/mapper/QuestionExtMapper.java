package life.weike.community.community.mapper;

import life.weike.community.community.model.Question;
import life.weike.community.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    Long incView(Question record);
    Long incCommentCount(Question record);
}