package ar.com.q3s.market.client.bo;

import java.util.List;

import ar.com.q3s.market.client.dao.DAO;
import ar.com.q3s.market.client.dao.DefaultDAO;
import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.util.ClassFinder;

public class DefaultBO implements BO {

	private DAO dao;
	
	public DefaultBO(Class<?> clazz){
    	try {
			dao = (DAO) Class.forName(ClassFinder.PACK_FULL_PATH + ClassFinder.PACK_DAO_TYPE + "." + clazz.getSimpleName() + "DAO").newInstance();
		} catch (Exception e) {
			dao = new DefaultDAO();
		}		
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
		if(entity.getId() == null){
			return dao.persist(entity);
		}else{
			return dao.merge(entity);
		}
	}

	@Override
	public boolean remove(Class<?> clazz, Long id) {
		return dao.remove(clazz,id);
	}
	
}