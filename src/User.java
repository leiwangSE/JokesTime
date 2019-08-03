


/**
 * User.java
 * 
 * secondchange 
 * This is a model class represents a user entity
 * 
 * This is the first change I make today
 * @author Lei
 *
 *
 *
 *
 */
public class User {
    protected String user_id; 
	protected String password;
    protected String first_name;
    protected String last_name;  
    protected String gender;
    protected int age;
    protected String status;
    


	public User() {
    }
 

	public User(String user_id) {
		this.user_id=user_id;
	}
    public User(String user_id, String password) {
    	this.user_id=user_id;
        this.password=password;
    }
    
    public User(String user_id,  String password, String  first_name, String last_name, String gender,int age, String status) {
        this(password, first_name, last_name, gender, age, status);
        this.user_id = user_id;
    }
     
    public User( String password, String first_name, String last_name, String gender,int age,String status) {
    	
    	this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        
        this.gender = gender;
        this.age = age;
        this.status = status;
    }
    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}


