package fr.formation.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.formation.model.Commentaire;

@Projection(name = "commentaireDR", types = { Commentaire.class })
public interface CommentaireDataRestProjection {
	public int getId();
	public String getPseudo();
}