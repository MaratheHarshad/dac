package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of " + getClass());
		try {
			// create user dao instance
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("em");
		String password = request.getParameter("pass");
		Date dob = Date.valueOf(request.getParameter("dob"));
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(dob);
		
		
//		 firstName, String lastName, String email, String password, Date dob
		
		User newUser = new User(firstName, lastName, email, password, dob);
		
		try {
			
			if(userDao.registerNewVoter(newUser)) {
				
				response.sendRedirect("candidate_list");
				
			}else {
				
				try(PrintWriter pw = response.getWriter()){
					pw.print("<h4> User Already Exist<a href='register.html'>Retry</a></h4>");
				}
			}
			
		}catch(Exception e) {
			throw new ServletException("Failed to register new user", e);
		}
		
		
		
	}

}
