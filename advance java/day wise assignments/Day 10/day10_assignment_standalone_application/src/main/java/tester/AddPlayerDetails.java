package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import pojos.Player;

public class AddPlayerDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			PlayerDao playerDao = new PlayerDaoImpl();
//			String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken
			System.out.println(
					"Enter player details : firstName,  lastName,  dob,  battingavg,  wicketstkn");
			// create transient entity /pojo
			Player p= new Player(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			//accept dept id
			System.out.println("Enter team id");			
			System.out.println(playerDao.addPlayer(p,sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
