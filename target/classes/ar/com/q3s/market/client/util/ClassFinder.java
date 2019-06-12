package ar.com.q3s.market.client.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.reflect.ClassPath;

import ar.com.q3s.market.client.model.EntityDomain;

public final class ClassFinder {

	private final static char DOT = '.';
	
	public static final String PACK_FULL_PATH = EntityDomain.class.getPackage().getName().substring(0,EntityDomain.class.getPackage().getName().lastIndexOf(".")) + DOT;
	public static final String PACK_MODEL_TYPE = "model";
	public static final String PACK_CONTROLLER_TYPE = "web";
	public static final String PACK_WEBSERVICE_TYPE = "ws";
	public static final String PACK_BO_TYPE = "bo";
	public static final String PACK_DAO_TYPE = "dao";
	
    public static List<Class<?>> find(final String scannedPackage) {
    	Set<Class<?>> classes = new HashSet<Class<?>>();
    	try {
    		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
    		for (final ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
    			if (info.getName().startsWith(scannedPackage+DOT)) {
    				final Class<?> clazz = info.load();
    				if(!EntityDomain.class.equals(clazz)){
    					classes.add(clazz);    					
    				}
    			}
    		}			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return sort(classes);
    }
    
    private static List<Class<?>> sort(Set<Class<?>> classes) {
    	Map<String,Class<?>> map = new LinkedHashMap<String,Class<?>>();
    	for (Class<?> clazz : classes) {
			map.put(clazz.getSimpleName(), clazz);
		}
    	List<Class<?>> finalClasses = new ArrayList<Class<?>>();
    	for (Entry<String,Class<?>> entry : map.entrySet()) {
			finalClasses.add(entry.getValue());
		}
		return finalClasses;
	}

	public static boolean exist(String simpleClassName, String type){
    	try {
			return exist(Class.forName(PACK_FULL_PATH + type + DOT + simpleClassName));
		} catch (Exception e) {
			return false;
		}
    }
    
    @SuppressWarnings("rawtypes")
	public static boolean exist(Class clazz){
    	for (Class element : find(PACK_FULL_PATH + PACK_MODEL_TYPE)) {
			if(element.equals(clazz)){
				return true;
			}
		}
    	return false;
    }
    
}