package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TeamDao;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamDao teamDao; 
	
	// service method to return list of teams abbreviations as String
	@Override
	public List<String> getTeamsAbbreviations(){
		
		return teamDao.getTeamsAbbreviations();
		
	}

	
}
