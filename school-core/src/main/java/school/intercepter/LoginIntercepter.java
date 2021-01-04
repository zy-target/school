package school.intercepter;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Strings.isNotBlank(header)){
            System.out.println("进入了，返回true");
            return true;
        }
        return true;
    }
}
