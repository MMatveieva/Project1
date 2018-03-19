import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isAllowed(user, pass)) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/app");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/errorLogin.html");
            rd.include(request, response);
        }
        out.close();
    }

    private static boolean isAllowed(String username, String password) {
        return username.contentEquals("mariia") && password.contentEquals("admin");
    }
}
