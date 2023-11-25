package tester;

import java.util.Scanner;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class UpdateTeamDetails {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			TeamDao dao=new TeamDaoImpl();
			
			System.out.println("Enter team id, wickets, batting avg");
			
			dao.updateTeamWicketsNBattingAvg(sc.nextInt(), sc.nextInt(), sc.nextDouble());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}
