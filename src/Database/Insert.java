package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// This is just a test class to test if the connection of the project to the database is correct, and you can move the code elsewhere

/**
 *
 * @author zeldr
 */
public class Insert {
    Connection con = Connect.connectdb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        double size = 300.0;
        String location = "Manila";
        double price = 5000000.0;

        // Insert the values into the LOTS table
        Insert db = new Insert();
        //db.insertLot(size, location, price);
        
        Delete delete = new Delete();
        // delete.deleteLot(2); // Replace with the ID of the lot you want to delete
        
        Report report = new Report();
        //report.displayLots();
        
        
    }
    
    public void insertLot(double size, String location, double price) {
        if (con == null) {
            System.out.println("Failed to establish a database connection.");
            return;
        }

        String sql = "INSERT INTO LOTS (size, location, price) VALUES (?, ?, ?)";

        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setDouble(1, size);
            st.setString(2, location);
            st.setDouble(3, price);
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error inserting lot: " + e.getMessage());
        }
    }
    
}
