import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.xml.crypto.Data;


public class Joke {
	 protected int joke_id;
	 protected String title;
     protected String description;
     protected String datetime;
     protected String user_id;
     
     
     public Joke(int joke_id, String title, String description, String user_id, String datetime) {
    	 this.joke_id=joke_id;
    	 this.title=title;
    	 this.description=description;
    	 this.user_id=user_id;
    	 this.datetime=datetime;
     }
     
     public Joke(int joke_id) {
    	 this.joke_id=joke_id;
     }
     
     public Joke(String title,String Description, String user_id)
     {
    	 this.user_id=user_id;
    	 this.title=title;
    	 this.description=Description;
     }
    
     
     public int getJoke_id() {
 		return joke_id;
 	}
 	public void setJoke_id(int joke_id) {
 		this.joke_id = joke_id;
 	}
 	public String getTitle() {
 		return title;
 	}
 	public void setTitle(String title) {
 		this.title = title;
 	}
 	public String getDescription() {
 		return description;
 	}
 	public void setDescription(String description) {
 	    this.description = description;
 	}
 	public String getDateTime() {
 		return datetime;
 	}
 	public void setDateTime(String datetime) {
 		this.datetime = datetime;
 	}
 	public String getUser_id() {
 		return user_id;
 	}
 	public void setUser_id(String user_id) {
 		this.user_id = user_id;
 	}
}
