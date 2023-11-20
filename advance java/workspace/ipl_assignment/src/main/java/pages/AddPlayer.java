package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/add_player")
public class AddPlayer extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// 1. set the content type
		res.setContentType("text/html");
		
		
		// 2. open the printWriter
		try(PrintWriter pw = res.getWriter()){
			
			// get session
						HttpSession session = req.getSession();
						
						// get daos from session scope
						PlayerDao playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
						TeamDao teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
						
						System.out.println("from Addplayer");
						System.out.println(playerDao);
						System.out.println(teamDao);
			
			
			pw.write("<h1>Add Player</h1>");
			
			RequestDispatcher rd = req.getRequestDispatcher("validate_player");
			rd.forward(req, res);

			
			
			pw.write("<h1>Add Player</h1>");
		
		}
		
	}

}
