package life.weike.community.community.mapper;

import life.weike.community.community.model.Question;
import life.weike.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value = "userId") long userId,@Param(value = "offset") Integer offset, @Param(value = "size")Integer size);
    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") long userId);

    @Select("select * from question where id=#{id}")
    Question getById(@Param("id") long id);

    void update(Question question);
}
