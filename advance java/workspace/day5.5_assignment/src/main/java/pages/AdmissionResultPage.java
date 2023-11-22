package pages;

import static utils.DBUtils.getCn;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.Student;

/**
 * Servlet implementation class AdmissionResultPage
 */
@WebServlet("/result")
public class AdmissionResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	
	@Override
	public void init(){
		userDao = new UserDaoImpl();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set content type
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h3> from 2nd page...." + request.getParameter("fn") + "</h3>");
		// get student details from req scoped attribute(server side object)
		Student s1 = (Student) request.getAttribute("student_dtls");
		if (s1 != null) {
			pw.print("<h4> Hello " + s1.getFirstName() + " " + s1.getLastName() + "</h4>");
			if (s1.isAdmissionStatus())
				
				
				// insert the student into the particular course
				
				pw.print("<h5> Congratulations ! , You are admitted in " + s1.getSelectedCourse() + "</h5>");
			else
				pw.print("<h5> Sorry  ! , Can't be  admitted in " + s1.getSelectedCourse() + "</h5>");
		}

	}
	
	@Override
	public void destroy(){
		
		// if instance is not null, then cleanup the resources
		if(userDao != null) {
			try {
				userDao.cleanUp();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
