package JDBC;

import java.sql.*;

public class Linker {
    String user;
    String url;
    private String password;
    private Connection con ;

       public Connection getConnection() {
        return con;
    }

    public Linker(String url, String user, String password)
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
            con = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            System.err.println("connection failed"); e.printStackTrace();
        }
    }
    }


