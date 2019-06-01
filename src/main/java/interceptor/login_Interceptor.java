package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lin
 * @Date 2019/6/1
 */
public class login_Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("login")){
            String username = (String) request.getSession().getAttribute("username");
            if (username==null){
                response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
                //不放行
                return false;
            }
        }
        //放行
        return true;
    }

}
