package tester;

import java.util.Scanner;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class GetTeamByAbbreviation {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team Abbreviation");
			
			Team team = teamDao.getTeamByAbbreviation(sc.next());
			
			System.out.println("Team with Abbreviation : " + team);
			
			
		}
	}
	
}