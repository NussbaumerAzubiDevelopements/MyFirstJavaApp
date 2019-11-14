import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDatabaseSevice {
    private final String url = "jdbc:postgresql://160.47.9.154:15432/q450811";
    private final String user = "admin";
    private final String password = "admin";
    private Connection con;

    public TaskDatabaseSevice() {
        try {
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public insert task
     * delete task
     * update task user
     * update task status
     * fetch all tasks
     * fetch task*/

    public int insert(Tasks insertTasks) {
        int result = 0;
        try {

            Statement stmt = con.createStatement();

            String query = "INSERT INTO public.Tasks" +
                    "VALUES ( , ?, ?, ?, ?, ?, ?, ?);";

            result = stmt.executeUpdate(query);


        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public int delete(Tasks deleteTasks) {
        int result = 0;
        try {

            Statement stmt = con.createStatement();

            String query = "DELETE FROM public.Tasks" +
                    "WHERE <condition>;";

            result = stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

//    public int update(Tasks updateTaskUser) {
//        int result = 0;
//        try {
//            Statement stmt = this.con.createStatement();
//
//            String query = "UPDATE public.Tasks SET assignedPersonId=? WHERE <condition>;";
//
//            result = stmt.executeUpdate(query);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return result;
//    }

    public int update(Tasks updateTaskStatus) {
        int result = 0;
        try {
            Statement stmt = this.con.createStatement();

            String query = "UPDATE public.Tasks SET status=? WHERE <condition>;";

            result = stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public List<Tasks> fetchAllTasks() {
        List<Tasks> tasksList = new ArrayList();
        try {

            //Creating a statement instance from the connection
            Statement stmt = con.createStatement();

            //Creating a result set from the executed statement query
            ResultSet rs = stmt.executeQuery("select * from Tasks ORDER BY task_id;");

            Tasks taskA;
            while (rs.next()) {
               char status = rs.getString(7).charAt(0);
               boolean deleteFlag;
               if (rs.getString("deleteFlag").equals("")){
                   deleteFlag = false;
               } else {
                   deleteFlag = true;
               }
                taskA = new Tasks(rs.getInt(1),rs.getInt(6), rs.getString(2), status,
                        deleteFlag , rs.getDate("createDate"), rs.getDate("startDate"),
                        rs.getDate("completeDate"));
                tasksList.add(taskA);
                //people.add(new Persons(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tasksList;
    }

    public Tasks fetchTask(int taskId) {
        Tasks taskA = new Tasks();
        try {

            //Creating a statement instance from the connection
            Statement stmt = con.createStatement();

            //Creating a result set from the executed statement query
            ResultSet rs = stmt.executeQuery("SELECT * from public.tasks WHERE task_id =" + taskId +  "LIMIT 1;");

           if (rs.next()) {
                char status = rs.getString(7).charAt(0);
               boolean deleteFlag;
               if (rs.getString("deleteFlag").equals("")){
                   deleteFlag = false;
               } else {
                   deleteFlag = true;
               }
                taskA = new Tasks(rs.getInt(1),rs.getInt(6), rs.getString(2), status,
                       deleteFlag, rs.getDate("createDate"), rs.getDate("startDate"),
                        rs.getDate("completeDate"));
            }else {
               System.out.println("No records found for task ID: " + taskId);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        return taskA;
    }
}




