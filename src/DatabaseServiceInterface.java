import java.util.List;

public interface DatabaseServiceInterface {
//    DatabaseServiceInterface instance = null;
    int insert(Persons insertPerson);
    int delete(Persons deletePerson);
    int update(Persons updatePerson);
    List<Persons> fetchAll();
    void close();

    Persons fetchById(int userId);

//    static DatabaseServiceInterface getInstance() {
//        if (instance == null){
//            instance = new DatabaseServiceImpl();
//        }
//        return instance;
//    }
}
