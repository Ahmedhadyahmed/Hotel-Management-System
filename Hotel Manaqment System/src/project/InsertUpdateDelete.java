package project;
import java.sql.*;
import javax.swing.JOptionPane;

public class InsertUpdateDelete {
    public static void setData(String Query, String msg) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();  // Assume this method provides a valid database connection
            st = con.createStatement();
            st.executeLargeUpdate(Query);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}