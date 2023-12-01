package tester;

import java.util.List;
import java.util.Scanner;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class GetTeamsListByMaxAge {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter age ");
			
			List<Team> teams = teamDao.getTeamsByMaxAge(sc.nextInt());
			
			System.out.println("Teams : ");
			teams.forEach(System.out::println);
			
			
		}
	}
	
}