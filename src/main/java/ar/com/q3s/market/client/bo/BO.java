package ar.com.q3s.market.client.bo;

import java.util.List;

import ar.com.q3s.market.client.model.EntityDomain;

public interface BO {
	List<?> list(Class<?> clazz);
	EntityDomain get(Class<?> clazz, Long id);
	boolean save(EntityDomain entity);
	boolean remove(Class<?> clazz, Long id);
}