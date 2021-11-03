import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {
    private final String PATH_TO_DB = "jdbc:sqlite:C:\\Users\\Ксения\\Desktop\\JAVA\\untitled8\\src\\main\\resources\\University.db";


    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void addStudent(Student student) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Students('name', 'faculty', 'age') " +
                        "VALUES(?, ?, ?)"

        )) {
            statement.setObject(1, student.name);
            statement.setObject(2, student.faculty);
            statement.setObject(3, student.age);
            statement.execute();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void deleteStudent(String name) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Students where name = ?"

        )) {
            statement.setObject(1, name);
            statement.execute();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT name, faculty, age FROM Students");
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString("name"),
                        resultSet.getString("faculty"),
                        resultSet.getString("age")
                ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return students;
    }

    }


