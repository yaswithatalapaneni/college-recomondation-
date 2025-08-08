
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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");

				PrintWriter out=response.getWriter();

				String fullname=request.getParameter("full_name");
				String username=request.getParameter("username");
				String email=request.getParameter("email");
				String phone=request.getParameter("phone");
				String password=request.getParameter("password");
				String confirmPassword = request.getParameter("confirm_password");
				String gender=request.getParameter("gender");
				String role=request.getParameter("role");
				
				if (!password.equals(confirmPassword)) {
		            out.println("<script>alert('Passwords do not match!'); window.location='signup.html';</script>");
		            return;
		        }


				LoginDAO dao =  new LoginDAO();

				boolean u;

				try {
					u= dao.insertUser(fullname,username,email,phone,password,gender,role);

					if(u)
					{
						RequestDispatcher rd=request.getRequestDispatcher("home.html");
						rd.forward(request, response);
					}
					else
					{
						out.println("already email exsist");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
