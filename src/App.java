import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class App {
    static int iFinal = 0;
    //    static DatabaseServiceInterface db = new DatabaseServiceImpl();
    static DatabaseServiceInterface db = DatabaseServiceImpl.getInstance();
    static TaskDatabaseSevice taskDatabaseSevice = new TaskDatabaseSevice();


    public static void main(String[] args) {


        Tasks tasks1 = taskDatabaseSevice.fetchTask(3);

        Scanner keyboardInput = new Scanner(System.in);
        boolean exitFlag = false;

        String name;
        System.out.println("Whats your name? ");
        name = keyboardInput.next();
        greetings(name);

        while (exitFlag != true) {

            System.out.print("\nWhat would you like to do? (show Persons = 1, add Person = 2, update Person = 3," +
                    " delete Person = 4, show Tasks = 5, add Task = 6, update Task = 7, delete Task = 8, exit = 9):");

            switch (keyboardInput.next()) {
                case "2":
                    insertDbData();
                    break;
                case "6":
                    showTasks();
                    break;
                case "4":
                    System.out.print("Which user would you like to delete? (person id):");
                    deleteDbData(keyboardInput.nextInt());
                    break;
                case "8":
                    System.out.print("Which task would you like to delete? (task id):");
                    deleteTasks(keyboardInput.nextInt());
                    break;
                case "exit":
                    exitFlag = true;
                    db.close();
                    System.out.println("Good bye " + name);
                    break;
                case "1":
                    System.out.println("Below is a list of Persons available");
                    getDbData();
                    break;
                case "5":
                    System.out.println("Below is a list of Tasks");
                    showTasks();
                    break;
                case "3":
                    System.out.println("Which user would you like to update? (person id):");
                    updateDbData(keyboardInput.nextInt());
                    break;
                case "7":
                    System.out.println("Below is a list of Tasks");
                    showTasks();
                    System.out.println("Which task would you like to update? (task id):");
//                    (keyboardInput.nextInt());
                    break;

                default:
                    System.out.println("You have selected an incorrect value!!");
                    break;
            }
        }
        //insertDbData();
        //
        //tryingNewClasses();
        //showTasks();
        //deleteTasks();

    }

    private static void deleteTasks(int taskId) {
    }

    private static void showTasks() {

        List<Tasks> tasks = taskDatabaseSevice.fetchAllTasks();
    }


    private static void updateDbData(int personId) {

        Scanner keyboardInput = new Scanner(System.in);
        Persons updatedPerson = new Persons();

        updatedPerson.setPersId(personId);

        System.out.print("User surname/Nachname :");
        updatedPerson.setNachname(keyboardInput.next());

        System.out.print("User First name/Vorname :");
        updatedPerson.setVorname(keyboardInput.next());

        System.out.print("User roll/Rolle :");
        updatedPerson.setRolle(keyboardInput.next());

        System.out.println(updatedPerson.toString());

//        int updateCount = db.update(updatedPerson);
//        System.out.println("number of Persons updated: " + updateCount);
        System.out.println("number of Persons updated: " + db.update(updatedPerson));
    }

    /*private static void connectAndUpdate(Persons updatedPerson, int personId) {
        String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
        String user = "admin";
        String password = "admin";
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            String query = "UPDATE public.personen  " + "SET nachname= '" + updatedPerson.getNachname() +
                    "',  vorname = '" + updatedPerson.getVorname() + "',  rolle= '" + updatedPerson.getRolle() +
                    "'  WHERE pers_id = " + updatedPerson.getPersId() + ";";

            int result = stmt.executeUpdate(query);
            System.out.println("number of Persons updated: " + result);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

    private static void deleteDbData(int personId) {
        Persons persons = new Persons();
        persons.setPersId(personId);
        int count = db.delete(persons);
        System.out.println("number of Persons deleted: " + count);
    }

      /*try {
        String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
        String user = "admin";
        String password = "admin";
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            String query = "DELETE FROM public.personen WHERE pers_id = " + personId + ";";

            int result = stmt.executeUpdate(query);
            System.out.println("number of Persons deleted: " + result);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }*/

    private static void insertDbData() {
        Scanner keyboardInput = new Scanner(System.in);
        Persons newPerson = new Persons();

        //Get user input from keyboard, set input on new person instance in two steps


        //Get user input from keyboard, set input on new person instance in one step
        System.out.print("User surname/Nachname :");
        newPerson.setNachname(keyboardInput.next());

        System.out.print("User First name/Vorname :");
        newPerson.setVorname(keyboardInput.next());

        System.out.print("User roll/Rolle :");
        newPerson.setRolle(keyboardInput.next());

        System.out.println(newPerson.toString());

        int count = db.insert(newPerson);
        System.out.println("Number of persons added " + count);
        //connectAndInsert(newPerson);
    }

   /* private static void connectAndInsert(Persons insertPerson) {
        String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
        String user = "admin";
        String password = "admin";

        /*try {

            Connection con = DriverManager.getConnection(url, user, password);


            Statement stmt = con.createStatement();

            String query = "INSERT INTO public.personen(pers_id, nachname, vorname, rolle)" +
                    " VALUES (" + insertPerson.getPersId() + ", '" + insertPerson.getNachname() + "','" +
                    insertPerson.getVorname() + "' ,'" + insertPerson.getRolle() + "');";

            int result = stmt.executeUpdate(query);
            System.out.println(result);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }*/


    private static void greetings(String name) {
        System.out.println("Good morning " + name);
    }

    private static void getDbData() {
        List<Persons> people = db.fetchAll();
        System.out.println("number of persons: " + people.size());

        //old way to loop through a list
        for (int i = 0; i < people.size(); i++) {
            Persons p = people.get(i);
            System.out.println("index:" + i + " = " + p.toString());
        }
    }


       /* String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
        String user = "admin";
        String password = "admin";

        try {
            //Creating connection instance to the database
            Connection con = DriverManager.getConnection(url, user, password);

            //Creating a statement instance from the connection
            Statement stmt = con.createStatement();

            //Creating a result set from the executed statement query
            ResultSet rs = stmt.executeQuery("select * from Personen");

            Persons personA;
	    		if(rs.next()) {
	    			personA = new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	    			System.out.println(personA.toString());
	    		}
	    		if(rs.next()) {
	    			personA = new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	    			System.out.println(personA.toString());
	    		}

            //Persons[] peopleArray = new Persons[6];
            //*List<Persons> people = new ArrayList();
            while (rs.next()) {
                personA = new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                people.add(personA);
                //people.add(new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

            System.out.println("number of persons: " + people.size());

            //new way to loop through a list
	    		/*people.forEach( p -> {
	    			iFinal++;
	    			System.out.println(iFinal);
	    			System.out.println(p);
	    		});*/


	    		/*Persons p = people.get(0);
				System.out.println(p.toString());
				 p = people.get(1);
				System.out.println(p.toString());
				 p = people.get(1);
				System.out.println(p.toString());
				 p = people.get(1);
				System.out.println(p.toString());
				 p = people.get(1);
				System.out.println(p.toString());
				 p = people.get(5);
				System.out.println(p.toString());*/

    //old way to loop through a list
           /* for (int i = 0; i < people.size(); i++) {

                Persons p = people.get(i);
                System.out.println("index:" + i + " = " + p.toString());
            }

            //while loop
				/*int i = 0;
				while(i < 6) {
					p = people.get(i);
					System.out.println(p.toString());
					i++;
				}*/

    //while(rs.next())
    //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4));
//}


}

