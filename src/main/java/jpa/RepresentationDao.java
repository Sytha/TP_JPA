package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class RepresentationDao {
	private EntityManager em;
	public RepresentationDao(EntityManager em){
		this.em=em;
	}
	
	public ArrayList<Representation> findAll(){
		return null;
	}
	
	public Representation findById(Long id){
		return em.find(Representation.class, id);
	}
	
	public List<Representation> findByCriteria(Date dateDeb, Date dateFin, String artiste){
		String jpql = "SELECT r "
				+ "FROM representation r "
				+ "WHERE r.date_representation <= :dateDeb "
				+ "AND r.date_representation >= : dateFin "
//				+ "AND r.spectacle.titre = :titre"
				;
		TypedQuery<Representation> query = em.createQuery(jpql, Representation.class); 
		query.setParameter(1, dateDeb);
		query.setParameter(1, dateFin);
		List<Representation> representations = query.getResultList();
		return representations;
	}
	
	public void persist(Representation representation){
		em.persist(representation);
	}
	

}
