package PS_lib;

import java.sql.*;
import java.util.Scanner;

public class LoginService {
    public static boolean login(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
