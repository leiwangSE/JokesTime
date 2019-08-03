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
 * This DAO class provides CRUD database operations for the table users
 * in the database.
 * @author Lei
 *
 */

public class UserDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     //connect with DB;
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//load DB driver, and each DB has its own driver;
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            //setup connection with DB;
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     //disconnect with the DB;
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     //prepareStatement allows to issue SQL query to DB
    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (user_id, password, first_name, last_name, gender, age, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUser_id());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getFirst_name());
        statement.setString(4, user.getLast_name());
        statement.setString(5, user.getGender());
        statement.setInt(6, user.getAge());
        statement.setString(7, user.getStatus());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();
         
        String sql = "SELECT * FROM joke.users";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String user_id = resultSet.getString("user_id");
            String password = resultSet.getString("password");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            int age =Integer.parseInt(resultSet.getString("age")) ;
            String status  = resultSet.getString("status"); 
            User user = new User(user_id, password, first_name, last_name, gender, age, status);
            listUser.add(user);
            //System.out.println("user_id");
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUser;
    }
     
    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users where user_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUser_id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;      
    }
     
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET  password = ?, first_name = ?, last_name = ?, gender=?, age=?, status=? where user_id=?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getPassword());
        statement.setString(2, user.getFirst_name());
        statement.setString(3, user.getLast_name());
        statement.setString(4, user.getGender());
        statement.setInt(5, user.getAge());
        statement.setString(6, user.getStatus());
        statement.setString(7, user.getUser_id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public User getUser(String id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE user_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	 String user_id = resultSet.getString("user_id");
             String password = resultSet.getString("password");
             String first_name = resultSet.getString("first_name");
             String last_name = resultSet.getString("last_name");
             String gender = resultSet.getString("gender");
             int age =Integer.parseInt(resultSet.getString("age")) ;
             String status  = resultSet.getString("status"); 
             user= new User(user_id, password, first_name, last_name, gender, age, status);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
	
	public boolean validate(User user) throws SQLException {
		boolean status=false;
		String sql = "SELECT * FROM joke.users where user_id=? and password=?";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getUser_id());
        statement.setString(2, user.getPassword());
        
        //System.out.println(statement);
        
        ResultSet rs= statement.executeQuery();
        status= rs.next();
        statement.close();
        disconnect();
        return status;  
	}
}
