package fr.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.formation.model.Commentaire;

//@RepositoryRestResource(path = "/commentaires", excerptProjection = CommentaireDataRestProjection.class)
//@RepositoryRestResource(excerptProjection = CommentaireDataRestProjection.class)
public interface ICommentaireDao extends JpaRepository<Commentaire, Integer> {
	@RestResource(path = "/by-pseudo")
	public List<Commentaire> findByPseudo(String pseudo);
}