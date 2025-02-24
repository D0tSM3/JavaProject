package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    public static Connection connectdb() {
        Connection con = null;
        try {
            // Connecting the project to the database
            con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/RealEstate.db");
            return con;
        } catch (SQLException e) {
            System.out.println("Connection Failed" + e);
            return null;
        }
    }
}