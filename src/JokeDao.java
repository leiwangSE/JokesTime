import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;



public class JokeDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    
    
    public JokeDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     public JokeDao() {
	
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
    public boolean insertJoke(Joke joke) throws SQLException {
        String sql = "INSERT INTO Jokes (Title, Description,user_id,DateTime) VALUES (?, ?, ?,?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, joke.getTitle());
        statement.setString(2, joke.getDescription());
        statement.setString(3,joke.getUser_id());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        statement.setString(4,timeStamp);
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Joke> listAllJokes() throws SQLException {
        List<Joke> listJokes = new ArrayList<>();
         
        String sql = "SELECT * FROM joke.Jokes";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int joke_id = Integer.parseInt(resultSet.getString("Joke_id"));
            System.out.println(joke_id);
            String title = resultSet.getString("Title");
            System.out.println(title);
            String description = resultSet.getString("Description");
            System.out.println(description);
            String user_id = resultSet.getString("User_Id");
            System.out.println(user_id);
            String datetime = resultSet.getString("Datetime");
            System.out.println(datetime);
            
            Joke joke = new Joke(joke_id, title, description, user_id, datetime);
            listJokes.add(joke);
            //System.out.println("user_id");
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listJokes;
    }

    public Joke getJoke() throws SQLException {
    	Joke maxJoke=null;
        String sql = "SELECT max(joke_id) from jokes;";
         
        connect();
        
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        if (resultSet.next()) {
        	int joke_id = Integer.parseInt(resultSet.getString("max(joke_id)"));
       
        maxJoke = new Joke(joke_id);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
		
		return maxJoke;
    	
    }
}
