package app.config;

import app.pojo.User;
import app.portal.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdcao on 2017/6/10.
 */
public class LoginInterceptor implements HandlerInterceptor{

    @Autowired
    private UserService userService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        if (userService == null) {//解决service为null无法注入问题
            System.out.println("userservice is null!!!");
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
            userService = (UserService) factory.getBean("UserService");
        }

        boolean isLogin = userService.getUserByToken(httpServletRequest, httpServletResponse);
        // 5、如果用户session已经过期，跳转到登录页面
        if (!isLogin) {
            httpServletResponse.sendRedirect("http://localhost:9090/user/showLogin");
            return false;
        }
        // 6、如果没有过期，放行。
        return true;

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
