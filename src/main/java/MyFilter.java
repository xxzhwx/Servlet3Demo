import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤操作：");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println(req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
