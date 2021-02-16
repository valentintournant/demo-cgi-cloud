package fr.formation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Commentaire;

@Repository
public class CommentaireRepository {
	@PersistenceContext
	private EntityManager em;
	
	public List<Commentaire> findAll() {
		return em.createQuery("select c from Commentaire c", Commentaire.class).getResultList();
	}
	
	public Commentaire findById(int id) {
		return em.find(Commentaire.class, id);
	}
	
	@Transactional
	public Commentaire save(Commentaire entity) {
		if (entity.getId() == 0) {
			em.persist(entity);
		}
		
		else {
			entity = em.merge(entity);
		}
		
		return entity;
	}
	
	@Transactional
	public boolean deleteById(int id) {
		try {
			em	.createQuery("delete from Commentaire c where c.id = ?1")
				.setParameter(1, id)
				.executeUpdate();
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
}