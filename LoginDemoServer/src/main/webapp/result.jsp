<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results - College Finder</title>
    <style>
        :root {
            --primary-color: #4361ee;
            --primary-light: #4895ef;
            --secondary-color: #3f37c9;
            --accent-color: #f72585;
            --dark-color: #1a1a2e;
            --light-color: #f8f9fa;
            --gray-color: #6c757d;
            --light-gray: #e9ecef;
            --white: #ffffff;
            --black: #000000;
            
            --border-radius: 8px;
            --box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            --transition: all 0.3s ease;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            line-height: 1.6;
            color: var(--dark-color);
            background-color: var(--light-color);
            transition: var(--transition);
        }

        body.dark-theme {
            background-color: var(--dark-color);
            color: var(--light-color);
        }

        .container {
            width: 100%;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Header & Navigation */
        .header {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            color: white;
            padding: 1rem 0;
            position: sticky;
            top: 0;
            z-index: 1000;
            box-shadow: var(--box-shadow);
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--white);
            text-decoration: none;
        }

        /* Results Section */
        .results-section {
            padding: 4rem 0;
            background-color: var(--white);
        }

        .dark-theme .results-section {
            background-color: #2a2a3a;
        }

        .section-header {
            text-align: center;
            margin-bottom: 3rem;
        }

        .divider {
            width: 80px;
            height: 4px;
            background-color: var(--primary-color);
            margin: 1rem auto;
            border-radius: 2px;
        }

        /* Results Table */
        .table-container {
            margin: 2rem auto;
            width: 90%;
            background-color: var(--white);
            box-shadow: var(--box-shadow);
            border-radius: var(--border-radius);
            overflow: hidden;
        }

        .dark-theme .table-container {
            background-color: #3a3a4a;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: var(--primary-color);
            color: var(--white);
            padding: 15px;
            text-align: left;
        }

        td {
            padding: 12px 15px;
            border-bottom: 1px solid var(--light-gray);
            text-align: left;
        }

        .dark-theme td {
            border-bottom: 1px solid #4a4a5a;
        }

        tr:hover {
            background-color: var(--light-gray);
        }

        .dark-theme tr:hover {
            background-color: #3a3a4a;
        }

        .no-results {
            font-size: 1.2rem;
            margin: 2rem 0;
            color: var(--gray-color);
            text-align: center;
        }

        .action-buttons {
            margin: 2rem 0;
            text-align: center;
        }

        .btn {
            display: inline-flex;
            align-items: center;
            padding: 0.75rem 1.5rem;
            border-radius: var(--border-radius);
            font-weight: 500;
            cursor: pointer;
            transition: var(--transition);
            text-decoration: none;
            border: none;
        }

        .btn i {
            margin-right: 0.5rem;
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: var(--white);
        }

        .btn-primary:hover {
            background-color: var(--secondary-color);
            transform: translateY(-2px);
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .table-container {
                width: 95%;
                overflow-x: auto;
            }
            
            table {
                min-width: 600px;
            }
        }

        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .results-section {
            animation: fadeIn 0.8s ease-out;
        }
    </style>
</head>
<body>
    <header class="header">
        <div class="container navbar">
            <a href="finder.jsp" class="logo">College Finder</a>
        </div>
    </header>

    <section class="results-section">
        <div class="container">
            <div class="section-header">
                <h1>📋 Search Results</h1>
                <div class="divider"></div>
            </div>

            <%
                Object resultObj = request.getAttribute("colleges");

                if (resultObj == null || !(resultObj instanceof java.util.List) || ((java.util.List<?>) resultObj).isEmpty()) {
            %>
                <p class="no-results">😔 No colleges found matching your criteria.</p>
            <%
                } else {
                    java.util.List<?> collegeList = (java.util.List<?>) resultObj;
            %>
            <div class="table-container">
                <table>
                    <tr>
                        <th>🏫 College Name</th>
                        <th>📍 Location</th>
                        <th>📘 Course</th>
                        <th>⭐ Ranking</th>
                    </tr>
                    <%
                        for (Object obj : collegeList) {
                            // since College is in default package, we just use reflection
                            String name = "";
                            String location = "";
                            String course = "";
                            int ranking = 0;

                            try {
                                Class<?> cls = obj.getClass();
                                name = (String) cls.getMethod("getName").invoke(obj);
                                location = (String) cls.getMethod("getLocation").invoke(obj);
                                course = (String) cls.getMethod("getCourse").invoke(obj);
                                ranking = (Integer) cls.getMethod("getRanking").invoke(obj);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    %>
                    <tr>
                        <td><%= name %></td>
                        <td><%= location %></td>
                        <td><%= course %></td>
                        <td><%= ranking %></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
            <%
                }
            %>
            <div class="action-buttons">
                <a href="Finder.html" class="btn btn-primary">
                    <i>🔍</i> New Search
                </a>
            </div>
        </div>
    </section>
</body>
</html>