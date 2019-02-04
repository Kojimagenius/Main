import JDBC.ClientHelper;
import JDBC.Linker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("Config");

        //helper.PrintResult(rs);
    }
}

               /* String SQL = "CREATE TABLE if not exists Clients " +
                        "(id INTEGER not NULL, " +
                        " name VARCHAR(50), " +
                        " City VARCHAR (50), " +
                        " PRIMARY KEY (id))";
                //query = "insert into Clients (id,NAME, City ) values (1 ,'Ciri Dun', 'Voronezh');";
                //st.executeUpdate(SQL);




            }  finally {
                try{l.getConnection().close();} catch(SQLException se){
                    System.out.println("can't close connection");se.printStackTrace();}
                // try{rs.close();} catch (SQLException se2) {
                // System.out.println("Can't close result");se2.printStackTrace();}
            }*/










