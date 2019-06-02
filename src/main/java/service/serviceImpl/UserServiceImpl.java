package service.serviceImpl;

import beans.User;
import dao.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;
import utils.PageUtils;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/5/28
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageUtils<User> findByPage(int currentPage,String username){
        PageUtils<User> pageUtils = new PageUtils<User>();
        //定义每页显示的记录数
        int pageSize = 5;
        //查询总记录数
        int totalRecord = userMapper.findAllRecords(username);
        //转成double类型方便查询总页数
        double tr = totalRecord;
        //查询总页数
        int totalPage = (int)Math.ceil(tr/pageSize);
        //查询每页显示的结果集  limit关键字设置从哪开始 查询几条 mysql中起始索引从0开始
        int start = (currentPage-1) * pageSize;
        List<User> lists = userMapper.findLists(start,pageSize,username);

        //开始封装
        pageUtils.setCurrentPage(currentPage);
        pageUtils.setPageSize(pageSize);
        pageUtils.setTotalRecord(totalRecord);
        pageUtils.setTotalPage(totalPage);
        pageUtils.setList(lists);

        return pageUtils;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void batchDeletion(Integer[] ids) {
        userMapper.batchDeletion(ids);
    }

    @Override
    public User checkUserByUsername(String username) {
       return userMapper.checkUserByUsername(username);
    }

}
