package app.mapper;

import app.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/23.
 */

public interface UserMapper {

    @Select("SELECT * FROM tb_user")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password",  column = "password"),
            @Result(property = "phone",  column = "phone"),
            @Result(property = "email",  column = "email"),
            @Result(property = "created",  column = "created"),
            @Result(property = "updated",  column = "updated")
    })
    List<User> getAll();

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password",  column = "password"),
            @Result(property = "phone",  column = "phone"),
            @Result(property = "email",  column = "email"),
            @Result(property = "created",  column = "created"),
            @Result(property = "updated",  column = "updated")
    })
    User getOne(Long id);

    @Insert("INSERT INTO tb_user(username,password,phone,email,created,updated) VALUES(#{username}, #{password}, #{phone}, #{email}, #{created}, #{updated})")
    void insert(User user);

    @Update("UPDATE tb_user SET username=#{username},password=#{password},phone=#{phone},email=#{email},created=#{created},updated=#{updated} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM tb_user WHERE id =#{id}")
    void delete(Long id);

}
