import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TagDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    JokeDao newJoke =new JokeDao();
    
    public TagDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertTag(Tag tag) throws SQLException {
        String sql = "INSERT INTO tags (tag, joke_id) VALUES (?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        int joke_id=newJoke.getJoke_id();
        statement.setString(1, tag.getTag());
        statement.setInt(2, joke_id);
       
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Tag> listTags() throws SQLException {
        List<Tag> listTags = new ArrayList<>();
         
        String sql = "SELECT * FROM tags";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int tag_id =Integer.parseInt(resultSet.getString("tag_id"));
            String tag  = resultSet.getString("tag"); 
            int joke_id =Integer.parseInt(resultSet.getString("joke_id"));
            Tag newTag = new Tag(tag_id,tag,joke_id);
            listTags.add(newTag);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listTags;
    }
     
}
