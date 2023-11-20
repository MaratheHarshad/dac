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

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;

import static utils.DBUtils.*;

/**
 * Servlet implementation class AddPlayerForm
 */

@WebServlet(value="/add_player_form", loadOnStartup = 1)
public class AddPlayerForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlayerDao playerDao;
	private TeamDao teamDao;

	@Override
	public void init() throws ServletException {
		
		try {
			
			// creating DAO instances
			openConnection();
			playerDao = new PlayerDaoImpl();
			teamDao = new TeamDaoImpl();
			
		} catch (SQLException e) {
			
			throw new ServletException("err in init" , e);		}
		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. set content type
		response.setContentType("text/html");
		
		// 2. open the printwriter
		
		try(PrintWriter pw = response.getWriter()){
			
			// 3. access the list of abbreviatinos using teamDao instance
			
			List<String> abbreviations = teamDao.getTeamsAbbreviations();
			
			// access the HttpSession and add Dao's instances in it
			
			HttpSession session = request.getSession();
			
			session.setAttribute("player_dao", playerDao);
			session.setAttribute("team_dao", teamDao);
			
			// create a form tag
			
			// dyn form generation
			pw.print("<form action='add_player' method='post' >");
			
			pw.print("<h5> choose a team : <select name='abbrevation'>");
			
			
			
			for(String s : abbreviations) {
				pw.print("<h5>");
				pw.print("<option  value='"+s+"'>"+s+"</option>");
				pw.print("</h5>");
			}
			
			pw.print("</h5> </select>");
			
			pw.print("<h5>player first name <input type='text' name='fn' /></h5>");
			pw.print("<h5>player last name <input type='text' name='ln' /></h5>");
			pw.print("<h5>DoB <input type='date' name='dob' /></h5>");
			pw.print("<h5>Batting Avg <input type='number' name='avg' /></h5>");
			pw.print("<h5>Wickets Taken <input type='text' name='wickets' /></h5>");
			pw.print("<h5><input <input type='submit' value='Add New Player' /></h5>");
			pw.print("</form>");
			
			
		} catch (SQLException e) {
			System.out.println("error in doGet of " + getClass());
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void destroy() {
		
		// incomplete
		
		try {
			closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(playerDao != null) {
			try {
				playerDao.cleanUp();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
 
}
