package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to insert new team details
	String addTeamDetails(Team newTeam);
	
	// add a method to get team by abbreviation
	Team getTeamByAbbreviation(String abr);
	
	// add a method to get teams by maxAge of the player by specified age
	List<Team> getTeamsByMaxAge(int age);
	
	
	// add a method to update teams'no of wickets taken and batting avg , specified y team_id
	
	void updateTeamWicketsNBattingAvg(int teamId, int wickets, double minBattingAvg);
	
	
	// add a method to return list of teams abr
	List<String> getTeamsAbr();
	
}
