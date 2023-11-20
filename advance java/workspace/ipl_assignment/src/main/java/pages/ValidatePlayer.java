package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

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
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class ValidatePlayer
 */
@WebServlet("/validate_player")
public class ValidatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlayerDao playerDao;
	private TeamDao teamDao;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside the do Post of " + getClass());
		
		// set the response content type
		// not actually useful, response content type status code can only be set ones
		// content type already set by caller
		response.setContentType("text/html");
		
		
		// grab the dao's instances and open the printWriter
		
		try(PrintWriter pw = response.getWriter();){
			
			pw.print("<h1>Inside Validate</h1>");
			
			
			// get session
			HttpSession session = request.getSession();
			
			// get daos from session scope
			playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			
			System.out.println(playerDao);
			System.out.println(teamDao);
				
			// access all the params from the req parameter and validate 
			
			
			String abr = request.getParameter("abbrevation");
			
			Team team = teamDao.getTeamDetails(abr.toUpperCase());
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			Date dob = Date.valueOf(request.getParameter("dob"));
			double battingAverage = Double.parseDouble(request.getParameter("avg"));
			int wickets = Integer.parseInt(request.getParameter("wickets"));
			
			
			int age = Period.between(LocalDate.now(), dob.toLocalDate()).getYears();
			// validate 
			if(battingAverage >= team.getMinBattingAvg() && wickets >= team.getMinWicketsTaken() && age < team.getMaxAge()) {
				
//				String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken, int teamId
				Player player = new Player(firstName, lastName, dob, battingAverage, wickets, team.getTeamId());
//				add player to the team
				playerDao.addPlayerToTeam(player, player.getTeamId());
				pw.print("<h1>Welcome to the Team "+ player.getFirstName()+" </h1>");
				
			}else {
				pw.print("<h1>Sorry You are not selected "+ firstName+" </h1>");
			}

			
		} catch (SQLException e) {
			System.out.println("Exception while validating data " + getClass());
		}
		
		
		
		
	}

}
