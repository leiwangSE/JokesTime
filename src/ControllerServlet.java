

import java.awt.TexturePaint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author 	Lei
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
 
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDao = new UserDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        System.out.println("Action: V2222222222" +action);
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
            default:
                listUser(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 User user= new User();
		 user.setEmail(email);
		 user.setPassword(password);
		 
		 if(userDao.validate(user)) {
			 response.sendRedirect("Index.jsp");
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
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        System.out.println(user_id);
        User existingUser = userDao.getUser(user_id);
        System.out.println(existingUser.password);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditUser.jsp");
        request.setAttribute("user", existingUser);
        //System.out.println(existingStudent.name);
        dispatcher.forward(request, response);
 
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email =request.getParameter("email");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String status = request.getParameter("status");
        User newUser = new User(password, first_name, last_name, email, gender, age, status);
        userDao.insertUser(newUser);
        response.sendRedirect("list");
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String status = request.getParameter("status");
 
        User user = new User(user_id, password, first_name, last_name, email, gender, age, status);
        userDao.updateUser(user);
        response.sendRedirect("UserList.jsp");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	System.out.println("user_id=");
    	System.out.println(request.getParameter("user_id"));
        int id = Integer.parseInt(request.getParameter("user_id"));
    	
        User user = new User(id);
        
        userDao.deleteUser(user);
        response.sendRedirect("list");
 
    }
    
}