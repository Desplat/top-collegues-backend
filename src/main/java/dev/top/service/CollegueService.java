package dev.top.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.vm.Avis;
import dev.top.controller.vm.AvisVM;
import dev.top.controller.vm.CollegueVM;
import dev.top.controller.vm.MatriculeVM;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

	private static final String API_URL = "https://tommy-sjava.cleverapps.io/collegues";
	private static final String FRONT_URL = "https://tommy-sjava.cleverapps.io/collegues";

	@Autowired
	private CollegueRepo collegueRepo;

	public List<Collegue> findAll() {

		return collegueRepo.findAll();
	}

	public Collegue updateScore(String pseudo, AvisVM avis) {

		Collegue collegueToUpdate = collegueRepo.findByPseudo(pseudo);

		if (avis.getAction() == Avis.AIMER) {
			collegueToUpdate.setScore(collegueToUpdate.getScore() + 10);
		} else if (avis.getAction() == Avis.DETESTER) {
			collegueToUpdate.setScore(collegueToUpdate.getScore() - 5);
		}
		return collegueRepo.save(collegueToUpdate);
	}

	public ResponseEntity<?> addCollegue(MatriculeVM matriculeVM) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<CollegueVM[]> response = restTemplate
				.getForEntity(API_URL + "?matricule=" + matriculeVM.getMatricule(), CollegueVM[].class);

		if (response != null) {
			Collegue collegueRetourne = new Collegue(0, matriculeVM.getPseudo(),
					matriculeVM.getUrlImage() != null ? matriculeVM.getUrlImage() : response.getBody()[0].getPhoto(),
					matriculeVM.getMatricule());
			if (this.collegueRepo.findByMatricule(matriculeVM.getMatricule()) == null) {
				this.collegueRepo.save(collegueRetourne);
			} else {
				System.out.println("Le collegue existe déjà");
			}
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
