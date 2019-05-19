
 
import java.awt.print.Book;
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
    private StudentDao studentDao;
 
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        studentDao = new StudentDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
                
            case "/insert":
                insertStudent(request, response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDao.listAllStudents();
        								
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Student existingStudent = studentDao.getStudent(id);
        System.out.println(existingStudent.name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
        request.setAttribute("student", existingStudent);
        //System.out.println(existingStudent.name);
        dispatcher.forward(request, response);
 
    }
 
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status =request.getParameter("status");
 
        Student newStudent = new Student(name, address, status);
        studentDao.insertStudent(newStudent);
        response.sendRedirect("list");
    }
 
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
 
        Student student = new Student(id, name, address, status);
        studentDao.updateStudent(student);
        response.sendRedirect("list");
    }
 
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Student student = new Student(id);
        
        studentDao.deleteStudent(student);
        response.sendRedirect("list");
 
    }
}