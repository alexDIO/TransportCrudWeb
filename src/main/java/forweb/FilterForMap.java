package forweb;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by olomakovskyi on 10/9/2014.
 */
public class FilterForMap implements Filter {
    private TransportMapHolder holder;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String className = filterConfig.getInitParameter("class");
        try {
            holder = (TransportMapHolder) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setAttribute("holder", holder);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
