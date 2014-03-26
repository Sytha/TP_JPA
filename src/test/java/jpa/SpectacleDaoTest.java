package jpa;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.SpectacleDao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetup;

import jpa.*;

public class SpectacleDaoTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private SpectacleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emFactory = Persistence.createEntityManagerFactory("TP_JPA");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emFactory.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emFactory.createEntityManager();
		dao = new SpectacleDao(em);
		loadTestData();
		em.getTransaction().begin();
	}

	private void loadTestData() {
		DbSetup dbSetup = new DbSetup(TestData.TEST_DESTINATION, 
				                      TestData.STANDARD_OPERATION);
		dbSetup.launch();
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testExistFindById(){		
		Spectacle s=dao.findById(1L);
		assertEquals("Dernier coup de ciseaux", s.getTitre());
	}
	
	@Test
	public void testNotExistFindById(){		
		Spectacle s=dao.findById(23156467L);
		assertNull("spectacle 23156467 n'existe pas!", s);
	}
	
	@Test
	public void testPersist(){		
		Spectacle s=new Spectacle();
		String titre = "olololo";
		s.setTitre(titre);
		s.setArtiste("JCVD");
		s.setType(TypeSpectacle.COMEDIE);
		dao.persist(s);
		em.flush();
		Spectacle s2 = dao.findById(s.getId());
		assertEquals(s2.getTitre(), s.getTitre());
	}
}
