import java.sql.*;
import java.util.*;

public class CollegeDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Krupss_369";

    public List<College> findColleges(String name, String location, String course, String ranking) throws SQLException {
        List<College> colleges = new ArrayList<>();

        StringBuilder query = new StringBuilder("SELECT * FROM college WHERE 1=1");

        if (name != null && !name.trim().isEmpty()) query.append(" AND LOWER(name) LIKE ?");
        if (location != null && !location.trim().isEmpty()) query.append(" AND LOWER(location) LIKE ?");
        if (course != null && !course.trim().isEmpty()) query.append(" AND LOWER(course) LIKE ?");
        if (ranking != null && !ranking.trim().isEmpty()) query.append(" AND ranking = ?");

        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            PreparedStatement ps = conn.prepareStatement(query.toString())
        ) {
            int index = 1;

            if (name != null && !name.trim().isEmpty())
                ps.setString(index++, "%" + name.trim().toLowerCase() + "%");
            if (location != null && !location.trim().isEmpty())
                ps.setString(index++, "%" + location.trim().toLowerCase() + "%");
            if (course != null && !course.trim().isEmpty())
                ps.setString(index++, "%" + course.trim().toLowerCase() + "%");
            if (ranking != null && !ranking.trim().isEmpty())
                ps.setInt(index++, Integer.parseInt(ranking.trim()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setName(rs.getString("name"));
                college.setLocation(rs.getString("location"));
                college.setCourse(rs.getString("course"));
                college.setRanking(rs.getInt("ranking"));
                colleges.add(college);
            }
        }

        return colleges;
    }
}