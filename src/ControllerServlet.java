

import java.awt.TexturePaint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author 	Lei
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
    private JokeDao jokeDao;
    private TagDao tagDao;
    private ReviewDao reviewDao;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDao = new UserDao(jdbcURL, jdbcUsername, jdbcPassword);
        jokeDao = new JokeDao(jdbcURL, jdbcUsername, jdbcPassword);
        tagDao = new TagDao(jdbcURL, jdbcUsername, jdbcPassword);
        reviewDao = new ReviewDao(jdbcURL, jdbcUsername, jdbcPassword);
        
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	  if (session == null)
    	  {
    		  response.sendRedirect("Login.jsp");
    	  }
        String action = request.getServletPath();
 
        System.out.println("Action: V2222222222" + action);
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
               
            case "/insert":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            case "/login":
                loginUser(request, response);
                break;
            case "/post":
            	if(null == session.getAttribute("user_id")){  
            		response.sendRedirect("Login.jsp");
            		}else{  
            			 insertJoke(request, response);
                         insertTag(request, response); 
            		} 
                break;
            case "/listposts":
                listJokes(request, response);
                break;  
            case "/review":
            	insertReview(request, response);
            default:
                listUser(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
   
	
	private void insertReview(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int score = Integer.parseInt(request.getParameter("score"));
		String remark = request.getParameter("remark");
		int joke_id = Integer.parseInt(request.getParameter("joke_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		Review review = new Review(score, remark, joke_id, user_id);
        reviewDao.insertReview(review);
        response.sendRedirect("list");
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 String user_id=request.getParameter("user_id");
		 String password=request.getParameter("password");
		 User user= new User();
		 user.setUser_id(user_id);
		 user.setPassword(password);
		 
		 if(userDao.validate(user)) {
			 HttpSession session=request.getSession();  
		     session.setAttribute("user_id",user_id); 
			 response.sendRedirect("JokePost.jsp");
		 }else{
			 response.sendRedirect("Failed.jsp");
		 };
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDao.listAllUsers();
        								
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String user_id = request.getParameter("user_id");
        User existingUser = userDao.getUser(user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditUser.jsp");
        request.setAttribute("user", existingUser);
        
//        System.out.println(user_id);
//        System.out.println(existingUser.email);
//        System.out.println(existingUser.password);
//        System.out.println(existingUser.gender);
//        System.out.println(existingUser.age);
        
        dispatcher.forward(request, response);
 
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
    	String user_id= request.getParameter("user_id");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String status = request.getParameter("status");
        User newUser = new User(user_id, password, first_name, last_name, gender, age, status);
        userDao.insertUser(newUser);
        response.sendRedirect("list");
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String status = request.getParameter("status");
 
        User user = new User(user_id, password, first_name, last_name, gender, age, status);
        userDao.updateUser(user);
        response.sendRedirect("UserList.jsp");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	System.out.println("user_id=");
    	System.out.println(request.getParameter("user_id"));
        String id = request.getParameter("user_id");
    	
        User user = new User(id);
        
        userDao.deleteUser(user);
        response.sendRedirect("list");
 
    }
    
    private void insertJoke(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
    	
    	String title = request.getParameter("title");
    	System.out.println(title);
        String description = request.getParameter("description");
        System.out.println(description);
        HttpSession session=request.getSession(); 
        
        String user_id=(String) session.getAttribute("user_id");
        System.out.println(user_id);
        
        Joke newJoke = new Joke(title, description, user_id);
        
        jokeDao.insertJoke(newJoke);
        
        
	}
    
    private void insertTag(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
    	String tag=request.getParameter("tags");
        System.out.println(tag);
        
    	
        Joke newJoke = jokeDao.getJoke();
        int newJoke_id = newJoke.getJoke_id();
        
        
        Tag newTag = new Tag(tag,newJoke_id);
        System.out.println("New tag is " + newTag.getTag());
        System.out.println("New joke id is " + newTag.getJoke_id());
        
        tagDao.insertTag(newTag);
       
        response.sendRedirect("listposts");
		
	}
    
    private void listJokes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Joke> listJokes = jokeDao.listAllJokes();
        List<Tag> listTags = tagDao.listTags();								
        request.setAttribute("listJokes", listJokes);	
        request.setAttribute("listTags", listTags);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowPost.jsp");
        dispatcher.forward(request, response);
    }

	

    
}