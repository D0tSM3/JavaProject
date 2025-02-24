package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zeldr
 */
public class Report {
    Connection con = Connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void displayLots() {
        String report = "SELECT * FROM LOTS";

        try {
            ps = con.prepareStatement(report);
            rs = ps.executeQuery();

            // Print column headers
            System.out.printf("%-10s %-10s %-10s%n", "Size", "Location", "Price");

            // Iterate through the ResultSet and print each row
            while (rs.next()) {
                double size = rs.getDouble("size");
                String location = rs.getString("location");
                double price = rs.getDouble("price");

                System.out.printf("%-10.2f %-10s %-10.2f%n", size, location, price);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving lots: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
