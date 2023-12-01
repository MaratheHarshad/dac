package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class AddNewTeam {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			TeamDao dao = new TeamDaoImpl();
			System.out.println("Enter new team details : name, abr, owner,  maxage, minbattingavg, wicketstkn");
			System.out.println(dao.addTeamDetails(new Team(sc.next(), sc.next(), sc.next(),sc.nextInt(), sc.nextDouble(), sc.nextInt())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
