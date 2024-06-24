package net.java.registration.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import net.java.registration.dao.UserDao;
import net.java.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/RegisterUser.jsp")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/RegisterUser.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Take all inputs
		String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String homeAddress = request.getParameter("homeaddress");
        String workAddress = request.getParameter("workaddress");
        
        
        try {
        	//Inserts data to user.java (Model)
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setHomeAddress(homeAddress);
            user.setWorkAddress(workAddress);
        	//Set user id from return result
            int id = userDao.registerUser(user); 
            user.setId(id);
            response.sendRedirect("Homepage.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.sendRedirect("Error.jsp");
        }
	}

}
