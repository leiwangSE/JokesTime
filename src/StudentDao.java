/*
 * 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author Lei
 *
 */

public class StudentDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public StudentDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     //connect with DB;
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//load DB driver, and each DB has its own driver;
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            //setup connection with DB;
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     //disconnect with the DB;
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     //prepareStatement allows to issue SQL query to DB
    public boolean insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (name, address, status) VALUES (?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getAddress());
        statement.setString(3, student.getStatus());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Student> listAllStudents() throws SQLException {
        List<Student> listStudent = new ArrayList<>();
         
        String sql = "SELECT * FROM Student";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("Name");
            String address = resultSet.getString("Address");
            String status = resultSet.getString("Status");
             
            Student student = new Student(id, name, address, status);
            listStudent.add(student);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listStudent;
    }
     
    public boolean deleteStudent(Student student) throws SQLException {
        String sql = "DELETE FROM student where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, student.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
        
    }
     
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET name = ?, address = ?, status = ? where id=?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getAddress());
        statement.setString(3, student.getStatus());
        statement.setInt(4, student.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Student getStudent(int id) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("Name");
            String address = resultSet.getString("Address");
            String status = resultSet.getString("Status");
            System.out.println(name);
            student = new Student(id, name, address, status);
        }
         
        resultSet.close();
        statement.close();
         
        return student;
    }
}
