package tester;

import java.util.Scanner;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class AddNewTeam {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			//create dao instance n call method
			TeamDao dao=new TeamDaoImpl();
			System.out.println("Enter new team details : String name, String abbreviation, String owner, int maxAge, double minBattingAvg,\r\n"
					+ "			int minWicketsTaken");
//			String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
//			int minWicketsTaken
			Team newTeam=new Team(sc.nextLine(), sc.next(), sc.next(),sc.nextInt()
					,sc.nextDouble(),sc.nextInt()); 
			System.out.println(dao.addTeamDetails(newTeam));
			
		} //sf.close() --> DBCP cleaned up ...
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
