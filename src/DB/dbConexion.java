package DB;

import java.sql.*;

public class dbConexion {

    static String url = "jdbc:mysql://localhost:3306/ddd";
    static String user = "root";
    static String pass = "Umg$2026";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    

  
}
