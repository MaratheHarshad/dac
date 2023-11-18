package tester;

import java.util.Scanner;

import dao.CandidateDao;
import dao.CandidateDaoImpl;
import pojos.Candidate;


public class TestIncreaseCandidateVotes {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			
			// init phase
			CandidateDao candidateDao = new CandidateDaoImpl();
			
			// servicing phase
			
			// fetch the candidate
			
			System.out.println("Enter the candidate id");
			Candidate candidate = candidateDao.getCandidate(sc.nextInt());
			
			if(candidate == null) {
				
				System.out.println("candidate does not exist");
				
			}else {
				// if user is valid
				System.out.println(candidate);
				candidateDao.updateCandidateVotes(candidate);
				
			}
			
			
			// destroy phase
			
			candidateDao.cleanUp();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}
