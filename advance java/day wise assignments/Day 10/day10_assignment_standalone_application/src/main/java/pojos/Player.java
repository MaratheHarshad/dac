package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//
//private int playerId;//PK
//private String firstName;
//private String lastName;
//private Date dob;
//private double battingAvg;
//private int wicketsTaken;
////FK 
//private int teamId;

/*
 * team_id | name| abbrevation | owner  | max_age | batting_avg | wickets_taken
 */
@Entity // mandatory cls level annotation , to tell hibernate ,
//following is the entity
		// class , whose life cycle to be managed by hibernate
@Table(name="players")
public class Player {
	
	@Id //mandatory anno , to place PK constraint
	//for auto id generation , using auto increment constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="player_id")
	private Integer playerId;// as per the founder(Gavin King) , till hib 5 , use id prop : explicitly
							// serializable
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;

	private LocalDate dob;
	private double battingAverage;
	private int wicketsTaken;
	
	// establish a bi - directional relationship using mappedBy annotations
	
//	player *<----->1 Team
	
	@ManyToOne()
	private Team myTeam;
	
	public Player(String firstName, String lastName, LocalDate dob, double battingAverage, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
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

	public Integer getPlayerId() {
		return playerId;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}
	
	

	
}
