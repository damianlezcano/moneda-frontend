package ar.com.q3s.market.client.web;

import java.util.Map;

import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.util.Response;

public interface Controller {
	Response index(Class<?> clazz, Long id, Map<String,Object> params);
	Response show(Class<?> clazz, Long id, Map<String,Object> params);
	Response edit(Class<?> clazz, Long id, Map<String,Object> params);
	Response create(Class<?> clazz, Long id, Map<String,Object> params);
	Response remove(Class<?> clazz, Long id, Map<String,Object> params);
	Response save(EntityDomain entity, Map<String, Object> params);
	Response update(EntityDomain entity, Map<String, Object> params);
}