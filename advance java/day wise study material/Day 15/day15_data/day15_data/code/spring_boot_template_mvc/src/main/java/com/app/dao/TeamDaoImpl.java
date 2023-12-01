package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// repository represents the data access object layer
@Repository
public class TeamDaoImpl implements TeamDao{
	
	// byType
	@Autowired
	private EntityManager mgr;
	
	
	@Override
	public List<String> getTeamsAbbreviations(){
		
		String jpql = "select t.abbreviation from Team t";
		
		List<String> list = mgr.createQuery(jpql, String.class).getResultList();
		
		System.out.println("list from dao : " + list);
		
		return list; 
	}

}
