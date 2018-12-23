import JDBC.ClientHelper;
import JDBC.Linker;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        String name = "test_user";
        String password = "qwerty";
        String url = "jdbc:postgresql://localhost:5432/test_database";
        // объект, соединяющий БД с джава
        Linker l = new Linker(url, name, password);
        l.connect();
        String sql ="CREATE TABLE Orders(id INTEGER NOT NULL, City VARCHAR(50), Entity VARCHAR(100), PRIMARY KEY(id)) ";
        try{
            Statement st = l.getConnection().createStatement();
            st.executeUpdate(sql);

        }catch (SQLException  e){
            System.err.println("failed to create table orders");
            e.printStackTrace();

        }catch (NullPointerException e1)
        {
            e1.printStackTrace();
        }
        try{sql = "CREATE TABLE Orders_Users(user_id INTEGER NOT NULL, order_id INTEGER NOT NULL, PRIMARY KEY(user_id), FOREIGN KEY(user_id) REFERENCES users(id), FOREIGN key(order_id) orders(id))";
            Statement st = l.getConnection().createStatement();
            st.executeUpdate(sql);   }catch(SQLException e){
            System.err.println("Failed to create table users_orders");
            e.printStackTrace();
        }
        ResultSet rs = null;

        System.out.println("Connection sucsess");
        ClientHelper helper = new ClientHelper(l); // Объект, позволяющий взаимподействовать с таблицей Clients
        helper.UpdateClient(1,"id", 6 );
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










