package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @date 2021/5/13 21:59
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);

    @Select("select * from user where id = #{id}")
    User finById(Integer id);

    @Select("select * from user where account = #{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set name = #{name} ,token = #{token} ,gmt_modified = #{gmtModified} , avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
