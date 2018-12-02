import java.rmi.ServerError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Linker {
    String user;
    String url;
    private String password;
    private Connection con ;

       public Connection getConnection() {
        return con;
    }

    public Linker(String user, String url, String password)
    {
        this.user = user;
        this.url = url;
        this.password = password;
        con = null;
    }

    public Linker(){}


    public void connect ()
    {
        try{Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException e){
            System.err.println("Driver not found");e.printStackTrace();}
        try {
            con = DriverManager.getConnection(url, user,password);
        }
        catch (SQLException e){
            System.err.println("connection failed"); e.printStackTrace();
        }
    }
    }


