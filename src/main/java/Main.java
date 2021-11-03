import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Student student1 = new Student("Mikle", "Mehmat", 19);
        Student student2 = new Student("Serg", "Mehmat", 20);
        Student student3 = new Student("Antony", "Matmeh", 14);
        Student student4 = new Student("Kate", "Matmeh", 21);
        Student student5 = new Student("Slava", "IFIAM", 23);

        DbHandler dbHandler = new DbHandler();

        dbHandler.deleteStudent("Mikle");
        System.out.println(dbHandler.getAllStudent());

    }
}
