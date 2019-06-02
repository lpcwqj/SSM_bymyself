package service;

import beans.User;
import utils.PageUtils;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/5/30
 */
public interface UserService {
    /**
     * 主页,分页
     * @param currentPage
     * @return
     */
    PageUtils<User> findByPage(int currentPage,String username);

    /**
     * 修改信息
     * @param user
     */
    void update(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 删除信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 批量删除 参数绑定数组
     * @param ids
     */
    void batchDeletion(Integer[] ids);

    /**
     * 根据用户名查询密码 验证密码是否正确
     * @param username
     */
    User checkUserByUsername(String username);

    /**
     * 根据用户名模糊查询
     * 分页显示
     * @param currentPage
     * @param username
     * @return
     */
//    PageUtils<User> fuzzyQuery(Integer currentPage, String username);
}
