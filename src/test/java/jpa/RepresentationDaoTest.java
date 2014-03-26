package jpa;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.RepresentationDao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetup;

import jpa.*;

public class RepresentationDaoTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private RepresentationDao dao;
	
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
		dao = new RepresentationDao(em);
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
	public void testFindByCriteriasTrue() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Representation> representations = null;
		representations = dao.findByCriteria(sdf.parse("28-05-2000"), sdf.parse("05-05-2100"), "Indochine");
		assertEquals(3, representations.size());
	}
}
