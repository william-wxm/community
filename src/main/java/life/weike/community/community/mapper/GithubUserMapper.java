package life.weike.community.community.mapper;

import life.weike.community.community.dto.GithubUser;
import life.weike.community.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GithubUserMapper {


    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Long id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User user);
}
