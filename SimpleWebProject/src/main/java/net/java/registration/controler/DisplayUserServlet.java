package net.java.registration.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.java.registration.db.DBUtil;
import net.java.registration.dao.DeleteUserDao;
import net.java.registration.dao.DispayUserDao;
import net.java.registration.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class DisplayUserServlet
 */

//Display users and delete (Post)
@WebServlet("/DisplayUsers.jsp")
public class DisplayUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeleteUserDao deleteUserDao = new DeleteUserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get parameter action of this URL
		String action = request.getParameter("action");
		
		try {
			
			//Connection to DB
			Connection conn = DBUtil.getConnection();
			
			if(action.equals("list")) {
				List<User> list = DispayUserDao.getUserList(conn);				
				
				//Return List of users from DB throw parameter
				request.setAttribute("list", list);
				request.getRequestDispatcher("/WEB-INF/views/DisplayUsers.jsp").forward(request, response);
				
			}
			
			conn.close();
		
		} catch(SQLException ex) {
			for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
			response.sendRedirect("Error.jsp");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("Error.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteUserDao.deleteUser(Integer.parseInt(request.getParameter("userID")));
            response.sendRedirect("Homepage.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.sendRedirect("Error.jsp");
        }
	}

}
