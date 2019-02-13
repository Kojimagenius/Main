import JDBC.ClientHelper;
import JDBC.Linker;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;


public class Main {
    @Autowired
    Environment env;
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.scan("Config");


    Linker link = new Linker("jdbc:postgresql://localhost:5432/test_database","test_user","qwerty");
    link.connect();
        try {
            Statement st = link.getConnection().createStatement();
            String query = "CREATE PROCEDURE 'GetUniqueId'(Low INT, Up INT)"+
                    "AS    BEGIN " +
                    "if not(Low < Up) return -1"+                                 //Defining stored procedure
                    "DECLARE Random INT;" +
                    "SELECT Random = ROUND(((Up - Low -1)* RAND() + Low), 0)" +
                    "WHILE EXISTS (SELECT * FROM users where id = Random)" +
                    "BEGIN SELECT Random = ROUND(((Up - Low -1)* RAND() + Low), 0) " +
                    "END " +
                    "SELECT Random" +
                    "END";
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}











