package com.pauslani.obrt.prevodenje;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pauslani.obrt.prevodenje.entitet.Kupac;
import com.pauslani.obrt.prevodenje.entitet.Obrt;
import com.pauslani.obrt.prevodenje.entitet.Racun;
import com.pauslani.obrt.prevodenje.entitet.StavkaRacuna;
import com.pauslani.obrt.prevodenje.entitet.Usluga;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

@SpringBootTest
class PrevodenjeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testDodajKupcaRacunStavkeRacuna() {
		
		EntityManager entityManager = new EntityManager() {
			
			@Override
			public <T> T unwrap(Class<T> cls) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void setProperty(String propertyName, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFlushMode(FlushModeType flushMode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void remove(Object entity) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh(Object entity, LockModeType lockMode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh(Object entity, Map<String, Object> properties) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh(Object entity) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void persist(Object entity) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public <T> T merge(T entity) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void lock(Object entity, LockModeType lockMode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void joinTransaction() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isOpen() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isJoinedToTransaction() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public EntityTransaction getTransaction() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T getReference(Class<T> entityClass, Object primaryKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, Object> getProperties() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Metamodel getMetamodel() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public LockModeType getLockMode(Object entity) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FlushModeType getFlushMode() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public EntityManagerFactory getEntityManagerFactory() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public EntityGraph<?> getEntityGraph(String graphName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getDelegate() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public CriteriaBuilder getCriteriaBuilder() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void flush() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T find(Class<T> entityClass, Object primaryKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void detach(Object entity) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createQuery(CriteriaDelete deleteQuery) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createQuery(CriteriaUpdate updateQuery) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createQuery(String qlString) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createNativeQuery(String sqlString, String resultSetMapping) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createNativeQuery(String sqlString, Class resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createNativeQuery(String sqlString) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Query createNamedQuery(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public EntityGraph<?> createEntityGraph(String graphName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean contains(Object entity) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
		};
	    // kreiraj novog kupca
		Kupac kupac = new Kupac();
		kupac.setImePrezime("Ime i prezime");
		kupac.setAdresa("Adresa");
		kupac.setOib("OIB");
		kupac.setEmail("Email");
		kupac.setBrojTelefona("Broj telefona");

		Racun racun = new Racun();
		racun.setBrojRacuna("123456");
		racun.setDatumIzdavanja(LocalDate.now());
		racun.setUkupanIznos(100.0);
		racun.setJir("JIR");
		racun.setNacinPlacanja("Nacin placanja");
		racun.setUkupanIznosNaknadeIPoreza(120.0);
		racun.setKupac(kupac);
		
		Obrt obrt = new Obrt();
		obrt.setId((long) 2);
		obrt.setAdresa("Adresa 1");
		obrt.setKontaktBroj("09583584679");
		obrt.setNaziv("Obrt za lekturu");
		obrt.setUrl("www.obrt.hr");
		obrt.setVlasnik("Ivo Ivic");
		
		Usluga usluga1 = new Usluga();
		usluga1.setCijenaPoJedinici(50.2);
		usluga1.setId((long) 10);
		usluga1.setJedinicaMjere("h");
		usluga1.setObrt(obrt);

		
		Usluga usluga2 = new Usluga();
		usluga2.setCijenaPoJedinici(51.2);
		usluga2.setId((long) 10);
		usluga2.setJedinicaMjere("h");
		usluga2.setObrt(obrt);

		StavkaRacuna stavka1 = new StavkaRacuna();
		stavka1.setUsluga(usluga1);
		stavka1.setKolicina(1);
		stavka1.setRacun(racun);

		StavkaRacuna stavka2 = new StavkaRacuna();
		stavka2.setUsluga(usluga2);
		stavka2.setKolicina(1);
		stavka2.setRacun(racun);

		racun.getStavkeRacuna().add(stavka1);
		racun.getStavkeRacuna().add(stavka2);
		
		entityManager.persist(racun);
	}

}
