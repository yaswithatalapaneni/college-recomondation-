import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import college.ApplicationStatus;

public class LoginDAO {
    static final String URL = "jdbc:mysql://localhost:3306/ testdb";
    static final String USER = "root";
    static final String PASS = "Krupss_369";

    public User validateUser(String usernamefnt, String passwordfnt) {
        User u1 = null;
        String query = "SELECT * FROM newusers WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Print received values for debugging
            System.out.println("🌐 Received Username: " + usernamefnt);
            System.out.println("🌐 Received Password: " + passwordfnt);

            if (usernamefnt == null || passwordfnt == null || usernamefnt.isEmpty() || passwordfnt.isEmpty()) {
                System.out.println("❌ Error: Username or Password is NULL or empty!");
                return null;
            }

            stmt.setString(1, usernamefnt);
            stmt.setString(2, passwordfnt);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    u1 = new User();
                    u1.setUsername(rs.getString("username"));
                    u1.setPassword(rs.getString("password"));
                    System.out.println("✅ User Found: " + u1.getUsername());
                } else {
                    System.out.println("❌ No matching user found in the database.");
                }
            }
        } catch (SQLException e) {
            System.err.println("⚠ SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        return u1; // Returns null if user is not found
    }
    public boolean insertUser(String fullname, String username, String email, String phone,String password,String gender,String role) throws SQLException, IOException {
        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;
        System.out.println("Insert User method");
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Insert new user
            String insertQuery = "INSERT INTO newusers (fullname,username,email,phone,password,gender,role) VALUES (?, ?, ?, ?,?,?,?)";
            insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, fullname);
            insertStmt.setString(2, username);
            insertStmt.setString(3, email);
            insertStmt.setString(4, phone);
            insertStmt.setString(5,password);
            insertStmt.setString(6,gender);
            insertStmt.setString(7, role);
            


            System.out.println(insertQuery);
            int rowsInserted = insertStmt.executeUpdate();
            
            System.out.println("Rows returned "+rowsInserted);
            if (rowsInserted > 0) {
                return true;
            } else {
                return false; // Insert failed
            }
        } finally {
            // Close all resources
            if (rs != null) rs.close();
            if (checkStmt != null) checkStmt.close();
            if (insertStmt != null) insertStmt.close();
            if (conn != null) conn.close();
        }
    }
    public ApplicationStatus getApplicationStatus(String applicationId) {
        ApplicationStatus status = null;
        String query = "SELECT status, last_updated, comments FROM applications WHERE application_id = ?";

        System.out.println("🌐 Received Application ID: " + applicationId);

        if (applicationId == null || applicationId.isEmpty()) {
            System.out.println("❌ Error: Application ID is NULL or empty!");
            return null;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, applicationId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    status = new ApplicationStatus();
                    status.setApplicationId(applicationId);
                    status.setStatus(rs.getString("status"));
                    status.setLastUpdated(rs.getTimestamp("last_updated"));
                    status.setComments(rs.getString("comments"));
                    System.out.println("✅ Application Status Found: " + status.getStatus());
                } else {
                    System.out.println("❌ No matching application found in the database.");
                }
            }
        } catch (SQLException e) {
            System.err.println("⚠ SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        return status;
    }

}