package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String format = request.getParameter("format");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String time = sdf.format(new Date());
            request.setAttribute("time", time);
            request.setAttribute("format", format);
            RequestDispatcher dispatcher = request.getRequestDispatcher("time.jsp");
            dispatcher.forward(request, response);
        } catch (IllegalArgumentException e) {
            response.sendRedirect("time.jsp?error=invalidFormat");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("time.jsp");
    }
}
