import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {
    String name = "test_user";
    String password = "qwerty";
    String url = "jdbc:postgresql://localhost:5432/test_database";
    Connection conn;
    try{
        Class.forName("org.postgresql.Driver");
    }catch(ClassNotFoundException e){
        System.err.println("driver not found");
        e.printStackTrace();
    }
    try{
        conn = DriverManager.getConnection(url,name,password);
    }
    catch(SQLException e){
        System.err.println("Connection failed");
        e.printStackTrace();
    }
    if(conn == null)
    {
        System.err.println("Connection failed");
    }
    }

