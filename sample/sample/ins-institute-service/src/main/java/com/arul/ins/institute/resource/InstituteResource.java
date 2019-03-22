package com.arul.ins.institute.resource;

import java.rmi.ServerException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arul.ins.institute.domain.Institute;
import com.arul.ins.institute.repository.InstituteRepository;

@RestController
public class InstituteResource {

	private static final Logger log = LoggerFactory.getLogger(InstituteResource.class);

	@Autowired
	InstituteRepository insRepo;

	@RequestMapping(value = "/institutes", method = RequestMethod.GET)
	public List<Institute> listAllInstitute() throws ServerException {
		log.debug("list");
		return insRepo.findAll();
	}

}