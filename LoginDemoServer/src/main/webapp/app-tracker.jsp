<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="college.ApplicationStatus" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Application Tracker</title>
    <link rel="stylesheet" href="style3.css">
    <style>
   
    .status-display {
        margin-top: 20px;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        transition: all 0.3s ease;
    }
    
    .status-display:hover {
        transform: translateY(-2px);
        box-shadow: 0 4px 15px rgba(0,0,0,0.15);
    }
    
    .status-display h3 {
        margin-top: 0;
        font-size: 1.5em;
        border-bottom: 1px solid rgba(0,0,0,0.1);
        padding-bottom: 10px;
        margin-bottom: 15px;
    }
    
    .status-display p {
        margin: 8px 0;
        font-size: 1.1em;
        line-height: 1.6;
    }
    
    .status-display strong {
        display: inline-block;
        width: 120px;
        color: inherit;
    }
    
    .status-pending {
        background-color: #FFF3CD;
        color: #856404;
        border-left: 5px solid #FFC107;
    }
    
    .status-approved {
        background-color: #D4EDDA;
        color: #155724;
        border-left: 5px solid #28A745;
    }
    
    .status-rejected {
        background-color: #F8D7DA;
        color: #721C24;
        border-left: 5px solid #DC3545;
    }
    
    .error {
        background-color: #F8D7DA;
        color: #721C24;
        border-left: 5px solid #DC3545;
        padding: 15px;
        border-radius: 5px;
    }
    
    
    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(10px); }
        to { opacity: 1; transform: translateY(0); }
    }
    
    .status-display {
        animation: fadeIn 0.5s ease-out;
    }
    
    
    @media (max-width: 600px) {
        .status-display strong {
            display: block;
            width: auto;
            margin-bottom: 5px;
        }
        
        .status-display p {
            margin-bottom: 15px;
        }
    }
</style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="home.html">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="index.html">Login</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="application-tracker">
        <h2>Application Tracker</h2>

        <form action="application" method="post">
            <label for="application_id">Application ID:</label>
            <input type="text" id="application_id" name="application_id" required>
            <button type="submit">Get Application Status</button>
        </form>

        <%
            ApplicationStatus status = (ApplicationStatus) request.getAttribute("status");
            String error = (String) request.getAttribute("error");

            if (status != null) {
                String statusClass = "";
                String lower = status.getStatus().toLowerCase();
                if (lower.contains("pending")) statusClass = "status-pending";
                else if (lower.contains("approved")) statusClass = "status-approved";
                else if (lower.contains("rejected")) statusClass = "status-rejected";
        %>
            <div class="status-display <%= statusClass %>">
                <h3>Application Status</h3>
                <p><strong>ID:</strong> <%= status.getApplicationId() %></p>
                <p><strong>Status:</strong> <%= status.getStatus() %></p>
                <p><strong>Last Updated:</strong> <%= status.getLastUpdated() %></p>
                <p><strong>Comments:</strong> <%= status.getComments() != null ? status.getComments() : "N/A" %></p>
            </div>
        <% } else if (error != null) { %>
            <div class="status-display error">
                <p><%= error %></p>
            </div>
        <% } %>
    </section>
</main>

<footer>
    <p>&copy; 2025 College Finder</p>
</footer>
</body>
</html>
