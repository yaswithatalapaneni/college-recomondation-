
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import college.ApplicationStatus;


/**
 * Servlet implementation class ApplicationSatusServlet
 */
@WebServlet("/application")

public class ApplicationStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ApplicationStatusServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String applicationId = request.getParameter("application_id");

         if (applicationId == null || applicationId.isEmpty()) {
             request.setAttribute("error", "Please enter a valid Application ID.");
             request.getRequestDispatcher("app-tracker.jsp").forward(request, response);
             return;
         }

         LoginDAO loginDAO = new LoginDAO();
         try {
             ApplicationStatus status = loginDAO.getApplicationStatus(applicationId);

             if (status != null) {
                 request.setAttribute("status", status);
             } else {
                 request.setAttribute("error", "No application found with the given ID.");
             }

         } catch (Exception e) {
             e.printStackTrace();
             request.setAttribute("error", "An error occurred while retrieving application status.");
         }

         request.getRequestDispatcher("app-tracker.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("✅ ApplicationStatusServlet initialized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
