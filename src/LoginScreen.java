import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginScreen {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
//			new com.mysql.jdbc.Driver();
            Class.forName("com.mysql.jdbc.Driver");
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
            String connectionUrl = "jdbc:mysql://localhost:3306/testdatabase";
            String connectionUser = "testuser";
            String connectionPassword = "testpassword";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next())
            {
                String id = rs.getString("id");
                String username = rs.getString("first_name");
                String password = rs.getString("last_name");
                System.out.println("ID: " + id + ", First Name: " + username
                        + ", Last Name: " + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
