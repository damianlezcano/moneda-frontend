package ar.com.q3s.market.client.ws;

import java.util.List;

import ar.com.q3s.market.client.bo.BO;
import ar.com.q3s.market.client.bo.DefaultBO;
import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.util.ClassFinder;

public class DefaultWebService implements WebService {

	private BO bo;
	
	public DefaultWebService(Class<?> clazz){
		try {
			bo = (BO) Class.forName(ClassFinder.PACK_FULL_PATH + ClassFinder.PACK_BO_TYPE + "." + clazz.getSimpleName() + "WebService").newInstance();
		} catch (Exception e) {
			bo = new DefaultBO(clazz);
		}
	}
	
	@Override
	public List<?> index(Class<?> clazz, Long id, EntityDomain entity){
		System.out.println("index ["+this.getClass().getSimpleName()+"]");
		return bo.list(clazz);
	}

	@Override
	public EntityDomain show(Class<?> clazz, Long id, EntityDomain entity){
		System.out.println("show ["+this.getClass().getSimpleName()+"] - id:" + id);
		return bo.get(clazz,id);
	}
	
	@Override
	public boolean save(Class<?> clazz, Long id, EntityDomain entity){
		System.out.println("save ["+this.getClass().getSimpleName()+"] - entity:" + entity);
		return bo.save(entity);
	}
	
	@Override
	public boolean remove(Class<?> clazz, Long id, EntityDomain entity){
		System.out.println("remove ["+this.getClass().getSimpleName()+"] - id:" + id);
		return bo.remove(clazz,id);
	}

}