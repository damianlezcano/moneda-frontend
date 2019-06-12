package ar.com.q3s.market.client.web;

import java.util.Map;

import ar.com.q3s.market.client.bo.MonedaBO;
import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.util.Response;

public class MonedaController implements Controller {

	private MonedaBO bo;
	
	public MonedaController(){
		bo = new MonedaBO();
	}
	
	@Override
	public Response index(Class<?> clazz, Long id, Map<String,Object> params){
		System.out.println("index ["+this.getClass().getSimpleName()+"] - params:" + params);
		return Response.ok(bo.list(clazz));
	}

	@Override
	public Response show(Class<?> clazz, Long id, Map<String,Object> params){
		System.out.println("show ["+this.getClass().getSimpleName()+"] - params:" + params);
		return Response.ok(bo.get(clazz,id));
	}

	@Override
	public Response create(Class<?> clazz, Long id, Map<String,Object> params){
		System.out.println("create ["+this.getClass().getSimpleName()+"] - params:" + params);
		try {
			return Response.ok(clazz.newInstance());
		} catch (Exception e) {
			return Response.fail();
		}
	}
	
	@Override
	public Response save(EntityDomain entity, Map<String,Object> params){
		System.out.println("save ["+this.getClass().getSimpleName()+"] - params:" + params);
		bo.save(entity);
		return Response.ok().redirect(entity.getClass().getSimpleName(),"show", entity.getId(), params).message("Creado exitosamente");
	}
	
	@Override
	public Response edit(Class<?> clazz, Long id, Map<String,Object> params){
		System.out.println("edit ["+this.getClass().getSimpleName()+"] - params:" + params);
		return Response.ok(bo.get(clazz,id));
	}

	@Override
	public Response update(EntityDomain entity, Map<String,Object> params){
		System.out.println("update ["+this.getClass().getSimpleName()+"] - params:" + params);
		bo.merge(entity);
		return Response.ok().redirect(entity.getClass().getSimpleName(),"show", entity.getId(), params).message("Modificado exitosamente");
	}
	
	@Override
	public Response remove(Class<?> clazz, Long id, Map<String,Object> params){
		System.out.println("remove ["+this.getClass().getSimpleName()+"] - params:" + params);
		EntityDomain entity = (EntityDomain)bo.get(clazz,id);
		boolean status = bo.remove(clazz,id);
		return status ? Response.ok(entity).message("Eliminado correctamente") : Response.fail(entity).message("No se pudo eliminar");
	}
}