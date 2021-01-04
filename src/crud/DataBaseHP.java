package crud;

import java.sql.*;

public class DataBaseHP {
       private final String userName="enes";
       private final String password = "1923";
       private final String dbUrl = "jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone= UTC";

       public Connection getConnection() throws SQLException{
           return DriverManager.getConnection(dbUrl,userName,password);
       }

       public void errorMessages(SQLException e){
           System.out.println("Error: "+e.getMessage());
           System.out.println("Error code: "+e.getErrorCode());     
       }
}
