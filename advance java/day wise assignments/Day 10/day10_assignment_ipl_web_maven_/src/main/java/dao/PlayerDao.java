package dao;

import pojos.Player;

public interface PlayerDao {
	//add a method to insert new player
	String addPlayer(Player p, int teamId);
	
	
}
