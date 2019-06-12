package ar.com.q3s.market.client.bo;

import java.util.List;

import ar.com.q3s.market.client.dao.MonedaDAO;
import ar.com.q3s.market.client.dao.DAO;
import ar.com.q3s.market.client.model.EntityDomain;

public class MonedaBO implements BO {

	private DAO dao;
	
	public MonedaBO(){
		dao = new MonedaDAO();
	}
	
	@Override
	public List<?> list(Class<?> clazz){
		return dao.list(clazz);
	}

	@Override
	public EntityDomain get(Class<?> clazz, Long id) {
		return dao.get(clazz,id);
	}

	@Override
	public boolean save(EntityDomain entity) {
		return dao.persist(entity);
	}

	public boolean merge(EntityDomain entity) {
		return dao.merge(entity);
	}
	
	@Override
	public boolean remove(Class<?> clazz, Long id) {
		return dao.remove(clazz,id);
	}
	
}