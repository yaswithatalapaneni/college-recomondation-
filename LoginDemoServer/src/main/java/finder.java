

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class finder
 */
@WebServlet("/finder")
public class finder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("Finder.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("collegeName");
        String location = request.getParameter("collegeLocation");
        String course = request.getParameter("collegeCourse");
        String ranking = request.getParameter("collegeRanking");

        CollegeDAO dao = new CollegeDAO();

        try {
            List<College> colleges = dao.findColleges(name, location, course, ranking);
            request.setAttribute("colleges", colleges);
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error occurred: " + e.getMessage() + "</h3>");
        }

	}

}
