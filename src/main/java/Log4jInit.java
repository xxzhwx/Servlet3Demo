import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Log4jInit extends HttpServlet {
    @Override
    public void init() throws ServletException {
        String prefix = getServletContext().getRealPath("/");
        System.setProperty("webAppRoot", prefix);

        System.out.println("user.dir: " + System.getProperty("user.dir"));

        String file = getInitParameter("log4j");
        if (file != null) {
            System.out.println("log4j.properties: " + prefix + file);
            PropertyConfigurator.configure(prefix + file);
        }
    }
}
