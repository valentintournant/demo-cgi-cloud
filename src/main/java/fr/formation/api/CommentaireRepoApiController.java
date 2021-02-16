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

import fr.formation.model.Commentaire;
import fr.formation.repository.CommentaireRepository;


//API REST AVEC CommentaireRepository
@RestController
@RequestMapping("/api/repo/commentaire")
public class CommentaireRepoApiController {
	@Autowired
	private CommentaireRepository daoCommentaire;
	
	@GetMapping
	public List<Commentaire> findAll() {
		return this.daoCommentaire.findAll();
	}
	
	@GetMapping("/{id}")
	public Commentaire findById(@PathVariable int id) {
		return this.daoCommentaire.findById(id);
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
		return this.daoCommentaire.deleteById(id);
	}
}