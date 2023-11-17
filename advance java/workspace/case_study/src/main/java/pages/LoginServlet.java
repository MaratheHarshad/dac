package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

// DEMO OF INTEGRATION OF SERVLET WITH JDBC

/**
 * Servlet implementation class LoginServlet
 */
// loadonstartup = 1 (eager loading), so that first request would not suffer the lazy loading
@WebServlet(description = "Servlet to login user", urlPatterns = { "/authenticate" })
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	
	
	// overriding form of method cannot throw new or broader exception 
	public void init() throws ServletException {
		// create user dao instance
		try {
			// create user dao instance
			
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
//			centralized err handling
			throw new ServletException("err in nit of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
		
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			// throw runtime exception, bcz compiler doesn't force the handling unchecked exception
			throw new RuntimeException("run time error in destroy ", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. set resp cont type
		response.setContentType("text/html");
		
		// 2. get PW to send buffered text resp to the clnt
		
		
		try(PrintWriter pw = response.getWriter()){
			
			
			
		}
		
		
		
		
	}

}
