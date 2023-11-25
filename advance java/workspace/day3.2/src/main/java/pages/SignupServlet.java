package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

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
		
		
//		1. set content type
		
		response.setContentType("text/html");
		
		
//		2. grab all the request parameters
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("em");
		String password = request.getParameter("pass");
		Date dob = Date.valueOf(request.getParameter("dob"));
		
		
//		Print all the input params to make sure the things are working
		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(password);
//		System.out.println(dob);
		
		
//		add a validation on input types (currently only one age of user should be > 18)
		
		try{
			validateAge(dob.toLocalDate());	
		}catch(Exception e) {
//			throw new ServletException("User is not 18 years old", e);
			try(PrintWriter pw = response.getWriter()){
				pw.print("<h4> User Age is not valid <a href='register.html'>Retry</a></h4>");
				
				
			}
			
		}
		
		
		
		
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
	
	// static method to validate the age of user, if user age is less than 21 then throw an error
	private static void validateAge(LocalDate dob) {
		
		Period age = Period.between(dob, LocalDate.now());
		
		if(age.getYears() < 21) {
			throw new RuntimeException("User Age is not valid");
		}
		
		System.out.println("User is matured enough to vote");
		
	}

}
