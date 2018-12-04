import java.sql.*;


public class JDBC {
    public static void main(String[] args) {
        String name = "test_user";
        String password = "qwerty";
        String url = "jdbc:postgresql://localhost:5432/test_database";
        // объект, соединяющий БД с джава
        Linker l = new Linker(url, name, password);

        ResultSet rs = null;
        l.connect();
        System.out.println("Connection sucsess");
        ClientHelper helper = new ClientHelper(l); // Объект, позволяющий взаимподействовать с таблицей Clients
        rs = helper.SelectClient("Voronezh");
        helper.PrintResult(rs);
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










