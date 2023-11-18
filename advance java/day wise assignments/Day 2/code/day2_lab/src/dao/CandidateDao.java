package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;
import pojos.User;

public interface CandidateDao {
//add a method to get all candidate details
	List<Candidate> getAllCandidates() throws SQLException;
	
	
//	add a method to return Candidate by candidate id
	
	Candidate getCandidate(int id) throws SQLException;
	
	
	
//	Increment candidate votes
	
	void updateCandidateVotes(Candidate candidate) throws SQLException;
	
//	method to cleanup 
	
	void cleanUp() throws SQLException;

}
