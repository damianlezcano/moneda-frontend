package ar.com.q3s.market.client.ws;

import java.util.List;

import ar.com.q3s.market.client.model.EntityDomain;

public interface WebService {
	List<?> index(Class<?> clazz, Long id, EntityDomain entity);
	EntityDomain show(Class<?> clazz, Long id, EntityDomain entity);
	boolean save(Class<?> clazz, Long id, EntityDomain entity);
	boolean remove(Class<?> clazz, Long id, EntityDomain entity);
}