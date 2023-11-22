package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionForm
 */
@WebServlet("/admission")
public class ProcessAdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get PW
		try (PrintWriter pw = response.getWriter()) {
			// 3. read req params
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");
			int marks = Integer.parseInt(request.getParameter("score"));
			Course course = Course.valueOf(request.getParameter("course").toUpperCase());
			// 4. wrap all student dtls in the student obj
			Student newStudent=new Student(fName, lName, marks, course);
			//5. process admission
			if(marks >= course.getMinMarks())
				newStudent.setAdmissionStatus(true);
			//6. save student details under suitable scope =request
			request.setAttribute("student_dtls", newStudent);//req scoped attr
			pw.print("<h3> from 1st page....</h3>");
		//	pw.flush();//rendering /sending / committing the resp
			//7. create RD object
			RequestDispatcher rd=request.getRequestDispatcher("result");
			//8. include the dyn contents of  Results page in the SAME request
			rd.include(request, response);
			/*
			 * WC : retains the resp buffer(PW's buffer) --> suspends exec of curnt page 
			 * ---> invokes doPost() of the next page -->  last page also can generate resp 
			 * 
			 *  after returning --> resp generated by all the pages in the chain ,  is rendered 
			 */
			System.out.println("control came back.....");
			pw.print("<h5> 1st page generating contents again....</h5>");
		}
	}

}
