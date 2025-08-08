
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CompareServlet")
public class dashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String college1 = request.getParameter("college1");
        String college2 = request.getParameter("college2");

        // For demo purposes, we'll just forward the names.
        request.setAttribute("college1", college1);
        request.setAttribute("college2", college2);

        // Forward to a JSP that handles comparison
        request.getRequestDispatcher("compare.jsp").forward(request, response);
    }
}
