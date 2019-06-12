package ar.com.q3s.market.client.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.proxy.HibernateProxy;

import ar.com.q3s.market.client.model.EntityDomain;

public class DefaultDAO implements DAO{

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.jpa");
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EntityDomain> list(Class<?> clazz) {
		List rt = new ArrayList();
		EntityManager em = emf.createEntityManager();
		List rs = em.createQuery("SELECT o FROM "+clazz.getSimpleName()+" o").getResultList();
		for (Object proxy : rs) {
			Object obj = null;
			if (proxy instanceof HibernateProxy){
				obj = ((HibernateProxy)proxy).getHibernateLazyInitializer().getImplementation();
			}else{
				obj = proxy;
			}
			rt.add(obj);
		}
		return rt;
	}

	@Override
	public EntityDomain get(Class<?> clazz, Long id) {
		EntityManager em = emf.createEntityManager();
		return (EntityDomain) em.find(clazz,id);
	}

	@Override
	public boolean persist(EntityDomain entity) {
		boolean state = true;
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        em.persist(entity);
			tx.commit();
		}catch(Exception e){
			state = false;
		} finally {
			em.close();
		}
		return state;
	}

	@Override
	public boolean merge(EntityDomain entity) {
		boolean state = true;
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        em.merge(entity);
			tx.commit();
		}catch(Exception e){
			state = false;
		} finally {
			em.close();
		}
		return state;
	}

	@Override
	public boolean remove(Class<?> clazz, Long id) {
		boolean state = true;
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        em.remove(get(clazz,id));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			state = false;
		} finally {
			em.close();
		}
		return state;
	}

}