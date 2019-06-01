package dao;


import beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Lin
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    int findAllRecords();

    /**
     * limit关键字 分页
     * @param start
     * @param size
     * @return
     */
    List<User> findLists(@Param("start") int start,@Param("size") int size);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(@Param("id") Integer id);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(@Param("id") Integer id);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 模糊查询
     * @param user
     * @return
     */
    List<User> vagueQuery(User user);

    /**
     * 批量删除 参数绑定数组
     * @param ids
     */
    void batchDeletion(Integer[] ids);

    /**
     * 根据用户名查询密码 验证密码是否正确
     * @param username
     * @return
     */
    User checkUserByUsername(@Param("username") String username);
}