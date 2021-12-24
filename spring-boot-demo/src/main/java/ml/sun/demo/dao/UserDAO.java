package ml.sun.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Sun
 * @date 2022/1/27
 */
@Mapper
public interface UserDAO {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return entity list
     */
    @Select("SELECT * FROM user WHERE username = #{username};")
    List<UserEntity> findByUsername(@Param("username") String username);
}
