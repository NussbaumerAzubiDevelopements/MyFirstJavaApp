import java.nio.channels.GatheringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseServiceImpl implements DatabaseServiceInterface {

    private final String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
    private final String user = "admin";
    private final String password = "admin";
    private Connection con;
    private static DatabaseServiceInterface instance;


    private DatabaseServiceImpl() {
        try {
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int insert(Persons insertPerson) {
        int result = 0;
        try {

            Statement stmt = con.createStatement();

            String query = "INSERT INTO public.personen(pers_id, nachname, vorname, rolle)" +
                    " VALUES (" + insertPerson.getPersId() + ", '" + insertPerson.getNachname() + "','" +
                    insertPerson.getVorname() + "' ,'" + insertPerson.getRolle() + "');";

            result = stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int delete(Persons deletePerson) {
        int result = 0;
        try {

            Statement stmt = con.createStatement();

            String query = "DELETE FROM public.personen WHERE pers_id = " + deletePerson.getPersId() + ";";

            result = stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int update(Persons updatePerson) {
        int result = 0;
        try {
            Statement stmt = this.con.createStatement();

            String query = "UPDATE public.personen  " + "SET nachname= '" + updatePerson.getNachname() +
                    "',  vorname = '" + updatePerson.getVorname() + "',  rolle= '" + updatePerson.getRolle() +
                    "'  WHERE pers_id = " + updatePerson.getPersId() + ";";

            result = stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<Persons> fetchAll() {
        List<Persons> personsList = new ArrayList();
        try {

            //Creating a statement instance from the connection
            Statement stmt = con.createStatement();

            //Creating a result set from the executed statement query
            ResultSet rs = stmt.executeQuery("select * from Personen ORDER BY pers_id;");

            Persons personA;

            while (rs.next()) {
                personA = new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                personsList.add(personA);
                //people.add(new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return personsList;
    }

    @Override
    public void close() {
        try {
            this.con.close();
            System.out.println("Connection to database is now closed." );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static DatabaseServiceInterface getInstance() {
        if (instance == null){
            instance = new DatabaseServiceImpl();
        }
        return instance;
    }
}
