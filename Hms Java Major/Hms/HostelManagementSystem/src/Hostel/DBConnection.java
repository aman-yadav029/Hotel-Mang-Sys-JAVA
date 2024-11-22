package Hostel;

import java.sql.*;

public class DBConnection {

    static Connection con;

    public static Connection createDBConnection() {
        //load Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Hostelms";
            String Username = "root";
            String password = "mysql@123";
            con = DriverManager.getConnection(url, Username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}


