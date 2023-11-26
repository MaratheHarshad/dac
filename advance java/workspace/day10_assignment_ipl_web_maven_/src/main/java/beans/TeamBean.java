package beans;

import java.util.ArrayList;
import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TeamBean {
	
	// props
	
	private TeamDao teamDao;
	
	public TeamBean() {
		teamDao = new TeamDaoImpl();
		System.out.println("Team Bean instance created");
	}

	// no need to set the variables
	// add a method to return the list of teams abr
	
	public List<String> teamsAbr(){
		
		List<String> teams = new ArrayList<>();
		
		// from here call the dao, method to get the list of teams abreviation
		teams = teamDao.getTeamsAbr();
		
		// print the list , to see it works :)
		teams.forEach(System.out::println);
		
		
		return teams;
	}
}
