package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import static utils.DBUtils.*;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;

	public CandidateDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// pst1 : to get all candidates
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes + 1 where id = ?");
		pst3 = cn.prepareStatement("select * from candidates where id = ?");
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		// create empty List
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}
	
	
//	method to update the candidate votes
	@Override
	public void updateCandidateVotes(Candidate candidate) throws SQLException {
		
		System.out.println("inside the updateCandidate Votes method");
		
		if(candidate == null) {
			
			System.out.println("no candidate found");
		}else {
			
//			set in params
			pst2.setInt(1, candidate.getCandidateId());
			
			int updateCount = pst2.executeUpdate();
			
			if(updateCount == 1) {
				System.out.println("candidate " + candidate + " votes count updated successfully");
			}else {
				System.out.println("error while updating the voter count");
			}
		}
		
	}
	
	
	
//	add a method to get the candidate by id
	@Override
	public Candidate getCandidate(int id) throws SQLException {
		
		// set IN params
		
		pst3.setInt(1, id);
		
		Candidate candidate = null;
		
		try(ResultSet rs = pst3.executeQuery()){
			
			while(rs.next()) {
				candidate = new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		}
		
		
		
		return candidate;
	}

	
	

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("candidate dao cleaned up....");
	}

	

	

	
}
