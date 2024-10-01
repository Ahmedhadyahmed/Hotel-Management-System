package project;

import java.sql.*;
import javax.swing.JOptionPane;

public class Tables {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            // Establishing the connection
            con = ConnectionProvider.getCon();
            
            // Check if the connection is null
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return;
            }

            st = con.createStatement();

            // Create the 'users' table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                                  + "id INT PRIMARY KEY AUTO_INCREMENT, "
                                  + "username VARCHAR(255), "
                                  + "Status BOOLEAN DEFAULT false)";
            st.executeUpdate(createTableSQL);

            // SQL statement to modify the default value of the column (assuming MySQL and boolean)
            String alterColumnSQL = "ALTER TABLE users MODIFY COLUMN Status BOOLEAN DEFAULT false";
            st.executeUpdate(alterColumnSQL);

            // Showing success message
            JOptionPane.showMessageDialog(null, "Table checked/created and column default value updated successfully");
        } catch (SQLException e) {
            // Handling specific SQL exceptions
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            // General exception handling
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Handle closing exceptions
                JOptionPane.showMessageDialog(null, "Closing Error: " + e.getMessage());
            }
        }
    }
}
