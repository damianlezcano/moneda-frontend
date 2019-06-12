package ar.com.q3s.market.client.dao;

import java.util.List;

import ar.com.q3s.market.client.model.EntityDomain;

public interface DAO {
	List<?> list(Class<?> clazz);
	EntityDomain get(Class<?> clazz, Long id);
	boolean persist(EntityDomain entity);
	boolean merge(EntityDomain entity);
	boolean remove(Class<?> clazz, Long id);
}