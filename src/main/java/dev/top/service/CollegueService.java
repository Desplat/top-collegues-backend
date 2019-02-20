package dev.top.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

	@Autowired
	private CollegueRepo collegueRepo;

	public List<Collegue> findAll() {

		return collegueRepo.findAll();
	}
}
