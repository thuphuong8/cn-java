package controller;

import javax.servlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletResponse;


public class FormatFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String format = request.getParameter("format");
        if (format != null) {
            try {
                new SimpleDateFormat(format);  // Kiểm tra định dạng
                chain.doFilter(request, response);
            } catch (IllegalArgumentException e) {
                ((HttpServletResponse) response).sendRedirect("time.jsp?error=invalidFormat");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
