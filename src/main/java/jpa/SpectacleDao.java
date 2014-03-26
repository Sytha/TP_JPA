package jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SpectacleDao {
	private EntityManager em;
	public SpectacleDao(EntityManager em){
		this.em=em;
	}
	
	public ArrayList<Spectacle> findAll(){
		return null;
	}
	
	public Spectacle findById(Long id){
		return em.find(Spectacle.class, id);
	}
	
	public Spectacle findByArtiste(String chaine){
		return null;
	}
	
	public void persist(Spectacle spectacle){
		em.persist(spectacle);
	}
	

}
