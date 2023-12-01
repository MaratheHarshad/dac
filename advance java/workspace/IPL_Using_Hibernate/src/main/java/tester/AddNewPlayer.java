package tester;

import java.time.LocalDate;
import java.util.Scanner;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import pojos.Player;

public class AddNewPlayer {

	public static void main(String[] args) {
try(Scanner sc = new Scanner(System.in)){
	PlayerDao dao = new PlayerDaoImpl();
	System.out.println("Enter player details along with team id:\nfirstName,lastName,dob,battingAverage,wicketsTaken");
	//String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken
	Player player = new Player(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
	System.out.println("Enter team id:");
	Long teamId = sc.nextLong();
	System.out.println(dao.addNewPlayer(player, teamId));
}
catch (Exception e) {
	// TODO: handle exception
e.printStackTrace();
}

	}

}
