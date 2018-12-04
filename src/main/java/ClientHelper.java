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
    }


    public <T> ResultSet  SelectClient(T option) {
        ResultSet rs = null;
        String query = null;
        try {
            st = link.getConnection().createStatement();
        }catch(SQLException e){
            System.err.println("Statement failed"); e.printStackTrace();
        }
        if(option instanceof Integer)
             query = "Select from clients where id = " + option + " ;";
        else if(option instanceof String && ((String) option).split(" ").length > 1)
             query = "Select from clients where name is like " + option + ";";
        else if(option instanceof String) query = "Select from clients where city is like " + option + "; ";
        try {
             rs = st.executeQuery(query);
        }catch(SQLException e){
            System.err.println("Invalid result");e.printStackTrace();
        }
        finally {
            try{rs.close();} catch (SQLException e) {
                 System.out.println("Can't close result");e.printStackTrace();}
            try {st.close();} catch (SQLException e){
                System.err.println("Failed to close statement"); e.printStackTrace();
            }
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
                    System.out.println("result: "+ id +  first_name + city );
                }
        }catch(SQLException e){
            System.err.println("Failed to print");e.printStackTrace();
        }
    }
    public  <T> void UpdateClient(T ref, String columnName, T target) {
        try{st = link.getConnection().createStatement();}
        catch(SQLException e){System.err.println("Statement failed"); e.printStackTrace();
        } //todo
        String query = "Update clients set " + columnName + "where id = " + ref ;
    }


    public void DeleteClient(int option){
        try {
            st = link.getConnection().createStatement();
        }catch (SQLException e){
            System.err.println("st fail"); e.printStackTrace();}
            String query = "Delete from clients where id = " + option + " ;" ;
        try {
            st.executeUpdate(query);
        }catch (SQLException e){
            System.err.println("Execute fail");e.printStackTrace();
        }

    }

    public void AddClient(int id, String Name, String City) {
        try {
             st = link.getConnection().createStatement();
        } catch (SQLException e) {
            System.err.println("Statement not created");
            e.printStackTrace();
        }
        try {String query = "INSERT INTO CLIENTS (id,Name,City) VALUES ("+
                id +", '"+ Name+ "' , '" + City + "');"; st.executeUpdate(query);}
                catch (SQLException e)
                {
                    System.err.println("Statement failed"); e.printStackTrace();
                }

    }
}