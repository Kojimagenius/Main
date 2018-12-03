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


    public <T, G> T[] SelectClient(G option) {
        //todo
        return null;
    }

    public void UpdateClient() {
        //todo
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