package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.controller.vm.AvisVM;
import dev.top.controller.vm.MatriculeVM;
import dev.top.entities.Collegue;
import dev.top.service.CollegueService;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private CollegueService collegueService;

	@GetMapping
	public List<Collegue> findAll() {

		return this.collegueService.findAll();
	}

	@PatchMapping("/{pseudo}")
	public Collegue updateScore(@PathVariable String pseudo, @RequestBody AvisVM action) {

		return this.collegueService.updateScore(pseudo, action);
	}

	@PostMapping
	public ResponseEntity<?> receiveMatricule(@RequestBody MatriculeVM matricule) {

		return this.collegueService.addCollegue(matricule);
	}
}
