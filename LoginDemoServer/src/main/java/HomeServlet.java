import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8' />");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0' />");
        out.println("    <title>College Finder - Home</title>");
        out.println("    <link rel='stylesheet' href='style3.css' />");
        out.println("    <link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap' rel='stylesheet' />");
        out.println("    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>");
        out.println("</head>");
        out.println("<body>");

        // Header
        out.println("<header><nav><ul>");
        out.println("<li><a href='home'>Home</a></li>");
        out.println("<li><a href='#about'>About</a></li>");
        out.println("<li><a href='index.html'>Login</a></li>");
        out.println("<li><a href='index2.html'>Sign Up</a></li>");
        out.println("<li><a href='dashboard.html'>Dashboard</a></li>");
        out.println("</ul></nav></header>");

        // Hero
        out.println("<section class='hero'>");
        out.println("<h1>Find Colleges That Match You</h1>");
        out.println("<p>Search by name, location, ranking, or course to discover your ideal college match.</p>");
        out.println("<div class='search-container'>");
        out.println("<input type='text' placeholder='Search by college name, location, ranking, or course...' />");
        out.println("<button class='animated-btn'>Search</button>");
        out.println("</div></section>");

        // College Finder Section
        out.println("<section class='feature'><h1>College Finder</h1>");
        out.println("<p>Search and explore colleges based on location, ranking, courses, and your preferences.</p>");
        out.println("<div class='con'><button class='animated-btn' onclick=\"window.location.href='finder.html'\">Find Colleges</button></div></section>");

        // Dashboard Section
        out.println("<section class='dashboard'><h2>Explore Your Options</h2><div class='cards'>");
        out.println("<div class='card glow-card'><div class='icon'><i class='fas fa-university'></i></div>");
        out.println("<h3>Colleges</h3><p>Explore a list of top colleges based on rankings, facilities, and student reviews.</p><button class='animated-btn'>View Colleges</button></div>");

        out.println("<div class='card glow-card'><div class='icon'><i class='fas fa-graduation-cap'></i></div>");
        out.println("<h3>Streams</h3><p>Discover academic streams that align with your career goals and interests.</p><button class='animated-btn'>View Streams</button></div>");

        out.println("<div class='card glow-card'><div class='icon'><i class='fas fa-award'></i></div>");
        out.println("<h3>Scholarships</h3><p>Find and apply for scholarships that match your qualifications and needs.</p><button class='animated-btn'>View Scholarships</button></div>");
        out.println("</div></section>");

        // Streams Section
        out.println("<section class='streams'><h2>Popular Academic Streams</h2><div class='blocks'>");
        out.println("<div class='block'><i class='fas fa-cogs'></i><h3>Engineering</h3><p>Discover top engineering colleges and specialized courses.</p></div>");
        out.println("<div class='block'><i class='fas fa-user-md'></i><h3>Medical</h3><p>Explore leading medical institutions and healthcare programs.</p></div>");
        out.println("<div class='block'><i class='fas fa-paint-brush'></i><h3>Arts</h3><p>Find excellent arts, humanities, and creative programs.</p></div>");
        out.println("</div></section>");

        // Tools and Features
        out.println("<section class='tools'><div class='features'>");
        out.println("<div class='feature'><i class='fas fa-tasks'></i><h2>Application Tracker</h2><p>Track your application status with real-time updates.</p><button class='animated-btn' onclick=\"window.location.href='app-tracker.html'\">Get Started</button></div>");
        out.println("<div class='feature'><i class='fas fa-lightbulb'></i><h2>Personalized Recommendations</h2><p>Receive custom suggestions based on your academic profile and goals.</p><button class='animated-btn'>Get Recommendations</button></div>");
        out.println("</div></section>");

        // Exams
        out.println("<section class='exams'><h2>Upcoming Entrance Exams</h2><ul class='exam-list'>");
        out.println("<li>JEE Main - Engineering Entrance Exam</li>");
        out.println("<li>NEET - National Eligibility cum Entrance Test</li>");
        out.println("<li>CLAT - Common Law Admission Test</li>");
        out.println("<li>CAT - Common Admission Test (MBA)</li>");
        out.println("<li>UPSC - Civil Services Examination</li>");
        out.println("</ul></section>");

        // Contact Section
        out.println("<section class='contact'><h2>Have Questions?</h2>");
        out.println("<p>We're here to help you. Reach out to our team for personalized assistance.</p>");
        out.println("<form><label for='name'>Name:</label><input type='text' id='name' name='name' required placeholder='Your name'>");
        out.println("<label for='email'>Email:</label><input type='email' id='email' name='email' required placeholder='Your email address'>");
        out.println("<label for='message'>Message:</label><textarea id='message' name='message' required placeholder='How can we help you?'></textarea>");
        out.println("<button type='submit' class='animated-btn'>Send Message</button></form></section>");

        // About Section
        out.println("<section id='about' class='about-section'><div class='container'>");
        out.println("<div><img src='https://img.freepik.com/free-vector/college-admission-concept-illustration_114360-8206.jpg' alt='About CollegeFinder' /></div>");
        out.println("<div><h2>About <span style='color: var(--primary);'>CollegeFinder</span></h2>");
        out.println("<p>CollegeFinder helps you discover top colleges, courses, and scholarships based on your preferences.</p>");
        out.println("<ul><li>Top colleges matching your preferences</li>");
        out.println("<li>Courses aligned with your career goals</li>");
        out.println("<li>Scholarship opportunities and more</li></ul>");
        out.println("<p>Whether you're just starting out or narrowing down your final choices, we're here to help.</p></div></div></section>");

       
        out.println("<footer><div class='social-links'>");
        out.println("<a href='#'><i class='fab fa-facebook'></i></a>");
        out.println("<a href='#'><i class='fab fa-twitter'></i></a>");
        out.println("<a href='#'><i class='fab fa-instagram'></i></a>");
        out.println("<a href='#'><i class='fab fa-linkedin'></i></a>");
        out.println("<a href='#'><i class='fab fa-youtube'></i></a>");
        out.println("</div>");
        out.println("<p>&copy; 2025 College Finder. All Rights Reserved.</p>");
        out.println("<p>Empowering students to find their perfect educational path.</p></footer>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}