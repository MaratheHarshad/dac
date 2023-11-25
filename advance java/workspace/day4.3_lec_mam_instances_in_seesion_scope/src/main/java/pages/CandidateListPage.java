package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.User;

@WebServlet( urlPatterns= "/candidate_list")
public class CandidateListPage extends HttpServlet {
	// doGet
	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in candidate list page ");
		// 1. set resp cont type
		rs.setContentType("text/html");
		// 2. get PW : to send resp from servlet ---> web clnt
		try (PrintWriter pw = rs.getWriter()) {
			// generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h5>Welcome Voter </h5>");
			// send validated user details retrieved from HttpSession
			// 1. get HttpSession from WC
			HttpSession session = rq.getSession();
			// 2. get user details from session scope
			User validUser = (User) session.getAttribute("clnt_details");
			if (validUser != null) {
				pw.print("<h4> Hello , " + validUser.getFirstName() + "</h4>");
				// get candidate dao ref from the session scope
				CandidateDaoImpl dao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
				// invoke dao's method to get list of candidates.
				List<Candidate> candidates = dao.getAllCandidates();
				// => no exc , dynamic form generation
				pw.print("<form action='logout'>");
				// generate radio btns dyn.
				for (Candidate c : candidates)
					pw.print("<h5><input type='radio' name='candidate_id' value='" + c.getCandidateId() + "'>"
							+ c.getCandidateName() + "</h5>");
				pw.print("<h5> <input type='submit' value='Cast A Vote'/></h5>");
				pw.print("</form>");
			} else
				pw.print("<h4> Session Tracking failed !!!!!!! No cookies.....</h4>");

		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in do-get :" + getClass(), e);
		}
	}

}



/*
 

// create a candidate_list servlet (hands on)

package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDao;
import pojos.Candidate;
import pojos.User;



@WebServlet ( urlPatterns = "/candidate_list")
public class CandidateListPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		
		
		System.out.println("inside candidate list page doGet");
		// set the resp content type
		
		resp.setContentType("text/html");
		
		// grab the HttpSession instance
		
		HttpSession session = req.getSession();
		
		// access the members stored inside the session
		
		// get the user details from the session storage
		
		User validUser = (User)session.getAttribute("clnt_details");
		
		// if user is not invalid
		
		if(validUser != null) {
			
			
			
			CandidateDao candidateDao = (CandidateDao)session.getAttribute("candidate_dao");
			
			// get the list of candidates
			try {
				List<Candidate> candidates = candidateDao.getAllCandidates();
				
				// grab the printWriter instance to write the resp body
				try(PrintWriter pw = resp.getWriter()){
					
					pw.write("<h1>Welcome Voter " + validUser.getFirstName() + "</h1>");
					
					pw.write("<h3>Canidates List<h3>");
					
					pw.print("<form action='logout'");
					
					// iterate through the candidates list and add candidates in form list
					
					for(Candidate c : candidates) {
						
//						pw.print("<h3><input type='radio' name='candidate_id' value=" +c.getCandidateId()+ "/>");
						pw.print("<h3><input type='radio' name='candidate_id' value='" + c.getCandidateId() +"'/>");
						pw.print("<lable>" + c.getCandidateName()+ "</lable></h3>");
					}
					
					pw.write("<h5><input type='submit' value='Cast A Vote' /></h5>");
					pw.print("</form>");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
		}
		
		
	}
	
}

 */