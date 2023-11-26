package beans;

import java.time.LocalDate;
import java.time.Period;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

//private int playerId;//PK
//private String firstName;
//private String lastName;
//private Date dob;
//private double battingAvg;
//private int wicketsTaken;
////FK 
//private int teamId;

public class PlayerBean {
	
	// props
	private PlayerDao playerDao;
	private TeamDao teamDao;
	
	// team info
	private String teamAbr;
	
	


	// player info
	private String firstName;
	private String lastName;
	private String dob;
	private double battingAverage;
	private int wicketsTaken;
	
	
	public PlayerBean() {
		playerDao = new PlayerDaoImpl();
		teamDao = new TeamDaoImpl();
		
		System.out.println("Player Bean instance created");
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public double getBattingAverage() {
		return battingAverage;
	}


	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}


	public int getWicketsTaken() {
		return wicketsTaken;
	}


	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	public String getTeamAbr() {
		return teamAbr;
	}


	public void setTeamAbr(String teamAbr) {
		this.teamAbr = teamAbr;
	}
	
	
	// add a beans method, to add new player to the team
	// no parameters have to passed because already values are set by WC by using setters
	public String addPlayer() {
		
		
		Team t = teamDao.getTeamByAbbreviation(teamAbr);
//		
//		
//		
//		return "player inserted";
		// 1. validate player information
		
		
		
		int age = Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
		
		
		// 2. if player is capable to store inside team then store the player
		// if true means, player is validated successfully
		if(age <= t.getMaxAge() && battingAverage >= t.getMinBattingAvg() && wicketsTaken >= t.getMinWicketsTaken()) {
			
			// create a player instance
			Player p= new Player(firstName, lastName, LocalDate.parse(dob), battingAverage, wicketsTaken);
			
			// add player in a team
			playerDao.addPlayer(p, t.getTeamId());
			
			return "Welcome To the team " + p.getFirstName() + " :)";
		}else {

			// 3. if player is not capable to store inside then display an appropriate message
			return "Sorry, You are not selected :(";
		}
		
	}
	
	

}
