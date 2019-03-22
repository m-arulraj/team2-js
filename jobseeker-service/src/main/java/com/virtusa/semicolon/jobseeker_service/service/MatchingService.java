package com.virtusa.semicolon.jobseeker_service.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class MatchingService {

	public String getUserName(String skills){
		String quer = "select USERNAME from EDUCATIONAL_DETAILS where SKILLS LIKE '%pattern%'";
		Set<String> skillset = new HashSet<>( Arrays.asList(skills.split(",")));
		Iterator<String> itr = skillset.iterator();
		while(itr.hasNext()){
			String pat = itr.next();
			String qry = "AND SKILLS LIKE '%pat%'";
		}
		return null;
		
	}
}
