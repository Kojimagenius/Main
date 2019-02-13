package JDBC;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class  ClientHelper {

    private Linker link = null;
    private Statement st;
    public ClientHelper() {
    }

    public ClientHelper(Linker l) {
        link = l;
        try {
            st = link.getConnection().createStatement();
        }catch(SQLException e){
            System.err.println("Statement failed"); e.printStackTrace();
        }
    }

    public void gentrateID(){ // функция, которая будет обеспечивать генерацию новых айди
        //и их вставку

    }

    public <T> ResultSet  SelectClient(T option) {
        ResultSet rs = null;
        String query = null;

        if(option instanceof Integer)
             query = "Select * from Users where id = '" + option + "';";
        else if(option instanceof String && ((String) option).split(" ").length > 1)
             query = "Select * from Users where name = '" + option + "';";
        else if(option instanceof String) query = "Select * from Users where city = '" + option + "' ; ";
        try {
             rs = st.executeQuery(query);
        }catch(SQLException e){
            System.err.println("Invalid result");e.printStackTrace();
        }


        return rs;
    }
    public void PrintResult(ResultSet rs) {
        try{
          while(rs.next())
                {
                    int id = rs.getInt(1);
                    String first_name = rs.getString(2);
                    String city = rs.getString(3);
                    System.out.println("result: "+ id +" " +  first_name+" " + city );
                }
        }catch(SQLException e){
            System.err.println("Failed to print");e.printStackTrace();
        }
    }
    public  <T> void UpdateClient(T ref, String columnName, T target) {
        try{st = link.getConnection().createStatement();}
        catch(SQLException e){System.err.println("Statement failed"); e.printStackTrace();
        }
        String query = "Update Users set " + columnName + " = " + target + "where id = " + ref ;
        try {
            st.executeUpdate(query);

        }catch(SQLException e){
            System.err.println("Statement fail"); e.printStackTrace();
        }
    }


    public void DeleteClient(int option){
            String query = "Delete from Users where id = " + option + " ;" ;
        try {
            st.executeUpdate(query);
        }catch (SQLException e){
            System.err.println("Execute fail");e.printStackTrace();
        }

    }

    public void AddClient(int id, String Name, String City) {
        try {String query = "INSERT INTO Users (id,Name,City) VALUES ("+
                id +", '"+ Name+ "' , '" + City + "');"; st.executeUpdate(query);}
                catch (SQLException e)
                {
                    System.err.println("Statement failed"); e.printStackTrace();
                }

    }
}