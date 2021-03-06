import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class Database {
    private static Connection connection;
    private static Statement statement;

    // Function to connect to the database
    public static void createConnection() throws SQLException {
        // Connect to the database
        connection = DriverManager.getConnection("jdbc:mysql://campus-directory.cgq9o4ofxzhr.us-east-2.rds.amazonaws.com:3306", "admin", "adminroot");
        // Create a statement
        statement = connection.createStatement();
    }

    // Function to close the connection
    public static void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Function to search for staff in the database
    public static ArrayList<Staff> searchStaff(String col, String str) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            // Execute a SQL query to search for any staff member where the specified column contains str
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Directory.Campus_Directory WHERE " + col + " LIKE '%" + str + "%'");
            // Save the results inside instances of Staff
            while (resultSet.next()) {
                staffList.add(new Staff(resultSet.getString("Name"), resultSet.getString("Image"), resultSet.getString("Department"),
                        resultSet.getString("Research"), resultSet.getString("Courses"), resultSet.getString("OfficeHours"),
                        resultSet.getString("OfficeLoc"), resultSet.getString("Email"), resultSet.getString("Phone_Number")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Return all of the results
        return staffList;
    }

    // Class to store staff info
    public static class Staff {
        public String name, image, department, research, courses, officeHour, officeLoc, email, phone;
        public Image icon;
        
        public Staff(String name, String image, String department, String research, String courses, String officeHour, String officeLoc, String email, String phone) {
            // Save all the different fields
            this.name = name;
            this.image = image;
            // Try to download the staff member's image
            try { icon = ImageIO.read(new URL(image)); } catch (IOException ex) { icon = null; }
            this.department = department;
            this.research = research;
            this.courses = courses.replaceAll("; ", "\n");
            this.officeHour = officeHour;
            this.officeLoc = officeLoc;
            this.email = email;
            this.phone = phone;
        }
    }
}
