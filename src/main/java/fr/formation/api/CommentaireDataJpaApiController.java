package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.exception.CommentaireNotFoundException;
import fr.formation.model.Commentaire;
import fr.formation.repository.ICommentaireDao;


//API REST AVEC DATA JPA ICommentaireDao (JpaRepository)
@RestController
@RequestMapping("/api/data-jpa/commentaire")
public class CommentaireDataJpaApiController {
	@Autowired
	private ICommentaireDao daoCommentaire;
	
	@GetMapping
	public List<Commentaire> findAll() {
		return this.daoCommentaire.findAll();
	}
	
	@GetMapping("/{id}")
	public Commentaire findById(@PathVariable int id) {
//		return this.daoCommentaire.findById(id).orElse(new Commentaire());
//		return this.daoCommentaire.findById(id).orElseThrow(() -> new CommentaireNotFoundException());
		return this.daoCommentaire.findById(id).orElseThrow(CommentaireNotFoundException::new);
	}
	
	@PostMapping
	public Commentaire add(@RequestBody Commentaire commentaire) {
		return this.daoCommentaire.save(commentaire);
	}
	
	@PutMapping("/{id}")
	public Commentaire edit(@PathVariable int id, @RequestBody Commentaire commentaire) {
		commentaire.setId(id);
		
		return this.daoCommentaire.save(commentaire);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoCommentaire.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
}