package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author zeldr
 */
public class Delete {
    Connection con = Connect.connectdb();
    PreparedStatement ps = null;

    public void deleteLot(int lotId) {
        String sql = "DELETE FROM LOTS WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, lotId);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A lot was deleted successfully!");
            } else {
                System.out.println("No lot found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting lot: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
