

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginD
 */
@WebServlet("/LoginD")
public class LoginD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	  
	        String usernamefnt = request.getParameter("uname");
	        String passwordfnt = request.getParameter("pwd");

	        // Print values to check if they are received correctly
	        System.out.println("🌐 Received Username: " + usernamefnt);
	        System.out.println("🌐 Received Password: " + passwordfnt);

	        // Check if any value is null
	        if (usernamefnt == null || passwordfnt == null || usernamefnt.isEmpty() || passwordfnt.isEmpty()) {
	            System.out.println("❌ Error: Username or Password is NULL or empty!");
	            out.print("<h3 style='color:red;'>Invalid Username or Password</h3>");
	            return; // Exit if values are null
	        }


	        LoginDAO dao = new LoginDAO();
	        User u1 = dao.validateUser(usernamefnt, passwordfnt);  // No need to catch SQLException

	        if (u1 != null && usernamefnt.equals(u1.getUsername()) && passwordfnt.equals(u1.getPassword())) {
	            
	            RequestDispatcher rd = request.getRequestDispatcher("home.html");
	            rd.forward(request, response);
	        } else {
	            
	            out.print("<h3 style='color:red;'>Invalid Username or Password</h3>");
	        }
	    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
