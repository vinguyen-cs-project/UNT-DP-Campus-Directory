import java.awt.Color;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Main {
    
    public static DirectoryFrame DirFrame;

    public static void main(String[] args) {
        try {
            // Try to set the visual style
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {}
        
        // Create windows and display the welcome message
        DirFrame = new DirectoryFrame();
        WelcomeFrame welcome = new WelcomeFrame();
        welcome.setLocationRelativeTo(DirFrame);
        welcome.setVisible(true);
        
        try {
            // Connect to Database
            Database.createConnection();
            
            // Launch the window
            welcome.setVisible(false);
            welcome.dispose();
            DirFrame.setVisible(true);
        } catch (SQLException ex) {
            // Mark the WelcomeFrame as the final window
            welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            
            // Display error message
            welcome.messageLabel.setForeground(Color.red);
            welcome.messageLabel.setText("Communication link failure. Please try again");
        }
    }

}
