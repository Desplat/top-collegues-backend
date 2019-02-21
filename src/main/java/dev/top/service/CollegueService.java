package dev.top.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.vm.Avis;
import dev.top.controller.vm.AvisVM;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

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

	public Collegue addCollegue(Collegue collegue) {

		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "https://tommy-sjava.cleverapps.io/collegues";
		Collegue collegueTrouve = restTemplate.getForObject(resourceUrl, Collegue.class);
		return collegueTrouve;
	}
}
