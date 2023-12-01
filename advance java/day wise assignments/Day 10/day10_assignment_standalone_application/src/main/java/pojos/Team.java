package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//create table teams (team_id int primary key auto_increment,name varchar(100),abbrevation varchar(10),owner varchar(20),max_age int,
//batting_avg double,wickets_taken int);

/*
 * team_id | name| abbrevation | owner  | max_age | batting_avg | wickets_taken
 */
@Entity // mandatory cls level annotation , to tell hibernate ,
//following is the entity
		// class , whose life cycle to be managed by hibernate
@Table(name="teams")
public class Team {
	@Id //mandatory anno , to place PK constraint
	//for auto id generation , using auto increment constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private Integer teamId;// as per the founder(Gavin King) , till hib 5 , use id prop : explicitly
							// serializable
	@Column(length = 100)
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@Column(length = 20)
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	
	
	// Team 1 <----> * player association
	
	@OneToMany(mappedBy = "myTeam")
	List<Player> players = new ArrayList<>(); // as per gaven king's suggestion for thie bi - directional association , initialized the empty list to avoid NullPtrExe 

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
	// as per gaven king's suggestion add a helper methods
	// add helper method to establish a bi dir asso between entities
	
	public void addPlayer(Player p) {
		players.add(p);
		p.setMyTeam(this);
		
	}
	
	// add helper method to de link bi-directional association between 2 entities
	public void removePlayer(Player p) {
		players.remove(p);
		p.setMyTeam(null);
		
	}
	


}
