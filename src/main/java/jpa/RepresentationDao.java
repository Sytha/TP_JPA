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
				+ "FROM Representation r "
				+ "JOIN r.spectacle sp "
				+ "WHERE r.dateRepresentation >= :dateDeb "
				+ "AND r.dateRepresentation <= :dateFin "
				+ "AND sp.artiste LIKE '%:artiste%'"
				;
		TypedQuery<Representation> query = em.createQuery(jpql, Representation.class); 
		query.setParameter("dateDeb", dateDeb);
		query.setParameter("dateFin", dateFin);
		query.setParameter("artiste", artiste);
		return query.getResultList();
		
	}
	
	public void persist(Representation representation){
		em.persist(representation);
	}
	

}
