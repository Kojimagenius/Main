import java.sql.*;


public class JDBC  {
    public static void main(String[] args) {
        String name = "test_user";
        String password = "qwerty";
        String url = "jdbc:postgresql://localhost:5432/test_database";
        Linker l = new Linker(url,name,password);
        Statement st  =null;
        ResultSet rs = null;
        String query = " ";
            try {
                l.connect();
                System.out.println("Connection sucsess");
                st = l.getConnection().createStatement();
                String SQL = "CREATE TABLE if not exists Clients " +
                        "(id INTEGER not NULL, " +
                        " name VARCHAR(50), " +
                        " City VARCHAR (50), " +
                        " PRIMARY KEY (id))";
                //query = "insert into Clients (id,NAME, City ) values (1 ,'Ciri Dun', 'Voronezh');";
                st.executeUpdate(SQL);
                st.executeUpdate(query);
                query ="Select * from Clients ; ";
                rs = st.executeQuery(query);

                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String first_name = rs.getString(2);
                    String city = rs.getString(3);
                    System.out.println("result: "+ id +  first_name + city );
                }

            }
            catch(SQLException e){
                System.err.println("failed");
                e.printStackTrace();

            }
            finally {
                try{l.getConnection().close();} catch(SQLException se){
                    System.out.println("can't close connection");se.printStackTrace();}
                    try{st.close();} catch (SQLException se1){
                        System.out.println("Can't close statement");se1.printStackTrace();
                    }
                    try{rs.close();} catch (SQLException se2) {
                        System.out.println("Can't close result");se2.printStackTrace();}
                }
            }


    }



