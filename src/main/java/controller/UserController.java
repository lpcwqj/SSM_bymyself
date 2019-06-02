package controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;
import utils.PageUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Lin
 * @Date 2019/5/28
 */

@Controller
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户登录
     * 验证用户是否存在 不存在直接提示 不判断密码
     * 验证密码是否正确 不正确进行提示进行重定向
     */
    @RequestMapping("login")
    public String checkLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpServletRequest request)
    {
        if ("".equals(username)){
            model.addAttribute("msg","User name cannot be empty");
            return "login";
        }
        if("".equals(password)){
            model.addAttribute("msg","Password cannot be empty");
            return "login";
        }
        User user = userService.checkUserByUsername(username);
        if (user == null){
            model.addAttribute("msg","User does not exist");
            return "login";
        }
        else if (!user.getPassword().equals(password)&&!"".equals(user.getPassword())){
            model.addAttribute("msg","Password is wrong");
            return "login";
        }
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("password",password);
        return "redirect:index";
    }

    /**
     * 跳转到主页面
     */
    @RequestMapping("index")
    public String findAll(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                          Model model,
                          HttpServletRequest request)
    {
        String username = request.getParameter("username");
        PageUtils<User> page = userService.findByPage(currentPage,username);
        model.addAttribute("page",page);
        return "index";
    }

    /**
     * 跳转到编辑页面 回显数据
     */
    @RequestMapping("toEdit")
    public String selectUserById(@RequestParam(value = "id") Integer id,
                                 Model model)
    {
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    /**
     * 修改信息
     */
    @RequestMapping("update")
    public String update(User user)
    {
        userService.update(user);
        return "redirect:/index";
    }

    /**
     * 删除
     */
    @RequestMapping("delete")
    public String delete(@RequestParam(value = "id") Integer id)
    {
        userService.delete(id);
        return "redirect:/index";
    }

    /**
     * 批量删除
     */
    @RequestMapping("batchDeletion")
    public String batchDeletion(Integer[] ids)
    {
        userService.batchDeletion(ids);
        return "redirect:/index";
    }

    /**
     * 添加用户
     */
    @RequestMapping("add")
    public String add(User user)
    {
        userService.add(user);
        return "redirect:/index";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session)
    {
        session.invalidate();
        return "login";
    }

}
