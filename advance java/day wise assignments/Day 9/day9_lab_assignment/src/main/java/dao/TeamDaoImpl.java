package dao;

import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		// 1. open hibernate session from SF
		Session session = getFactory().openSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			// end of try => success
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx n re throw the exc to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// close the session
			if (session != null)
				session.close();
		}
		return "Added new Team with ID " + newTeam.getTeamId();
	}

	// method to return list of teams by abbreviation
	@Override
	public Team getTeamByAbbreviation(String abr) {

		Team team = null;

		// to upper case the abr
		abr = abr.toUpperCase();

		// java persistance query to retirive the teams with specified abbreviation
		String jpql = "select t from Team t where t.abbreviation = :abr";

		// database session from fetFactory().getCurrentSession()
		Session session = getFactory().getCurrentSession();

		// create instance of Transactions
		Transaction tx = session.beginTransaction();

		try {

			team = session.createQuery(jpql, Team.class).setParameter("abr", abr).getSingleResult(); // PERSISTANCE pojo
			// commit the transaction
			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
			
		} 
		
		return team;
	}

	
	@Override
	public List<Team> getTeamsByMaxAge(int age) {

		
		List<Team> teams = null;
		
//		jpql
		String jpql = "select t from Team t where t.maxAge > :age";
		
//		get session
		Session session = getFactory().getCurrentSession();
		
//		create and begin transaction
		Transaction tx = session.beginTransaction();
		
		
//		try catch
		
		try {
		
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).getResultList();
			
			
			tx.commit(); // tx success --> commit
			
		}catch(RuntimeException e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			throw e;
			
		}
		
		return teams;
	}

	
	
	@Override
	public void updateTeamWicketsNBattingAvg(int teamId, int wickets, double minBattingAvg) {
		
		// get a session
		Session	session = getFactory().getCurrentSession();
		
		// begin a transaction 
		Transaction tx = session.beginTransaction();
		
		try {
			
			// access the Team
			Team team = session.get(Team.class, teamId); // PERSISTENCE reference
			
			team.setMinBattingAvg(minBattingAvg);
			team.setMinWicketsTaken(wickets);
			
			tx.commit(); // success --> commit
			
			System.out.println("Team Details Updated Successfully");
			
		}catch(RuntimeException e) {

			if(tx != null) {
				tx.rollback();
			}
			
			System.out.println("Failed to update Team detail");
			
			throw e;
		}
		
		
	}

	
}
