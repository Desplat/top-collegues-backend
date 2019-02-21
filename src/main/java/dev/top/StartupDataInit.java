package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Component
public class StartupDataInit {

	@Autowired
	CollegueRepo collegueRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		this.collegueRepo.save(new Collegue(0, "Galilée",
				"https://static.wamiz.fr/images/articles/facebook/article/chiot-fb-593feaf4e2a87.jpg"));
		this.collegueRepo.save(new Collegue(0, "Pasteur",
				"http://valgauxloups.fr/wp-content/uploads/2018/10/acheter-chiot-mignon-fb-59886f5dedd43-2.jpg"));
		this.collegueRepo.save(new Collegue(0, "Darwin",
				"https://static.wamiz.fr/images/articles/facebook/article/chiot-obeir-bande-fb-5b2cca71a9ee0.jpg"));
		this.collegueRepo.save(new Collegue(0, "Curie",
				"https://www.weenect.com/blog/wp-content/uploads/2017/05/promenade-chiot-1.jpg"));
		this.collegueRepo.save(new Collegue(0, "Eistein",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ92ZpDUbLDYTFKVVbJSb80mX1pO5DkwMaFLOzzUzptdw_hAZ1c9g"));
		this.collegueRepo.save(new Collegue(0, "Tesla",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJnLEDDQqYNO-0jJWbh3Wc_H_s9SZM0WIkG2zQ9WhBeLq0cNeZ"));
		this.collegueRepo.save(new Collegue(0, "Copernic",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3JvmSzV0HzHDzXDer8d2Q5ezL-RpXjZPyobPkrrxmQHvMsjpiVw"));
		this.collegueRepo.save(new Collegue(0, "Montaigne",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDbeDsnlM5arL43Ec9GC-3qEVyiZ3h95YdaXDqkGwNdnDU05ru0g"));
		this.collegueRepo.save(new Collegue(0, "Diderot",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRH4PBI5sc8ZT-6Pfq6BP0rRApfSTCGV_qurI7BlfYtgL9ZkX3"));
		this.collegueRepo.save(new Collegue(0, "Voltaire",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC0so4NFEBZj7E-0JKQQbqwWDDwVpJnRBxMiPMiqCnvTpuSNM3sg"));
	}
}
