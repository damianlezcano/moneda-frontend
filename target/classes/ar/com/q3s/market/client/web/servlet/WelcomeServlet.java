package ar.com.q3s.market.client.web.servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import ar.com.q3s.market.client.util.ClassFinder;

public class WelcomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3324097373661605976L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		System.out.println("--------------------------------------------");
    		//get context URI
    		String contextParam = request.getServletPath();
    		//--------------------------------------------------------------
	    	Map<String, Object> params = new HashMap<String,Object>();
	    	params.put("context", contextParam);
	    	params.put("entities", ClassFinder.find(ClassFinder.PACK_FULL_PATH + ClassFinder.PACK_MODEL_TYPE));
	    	
	        /*  first, get and initialize an engine  */
	        VelocityEngine ve = new VelocityEngine();
	        
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        
	        ve.init();
	        /*  next, get the Template  */
	        VelocityContext context = new VelocityContext();
	        Template t = ve.getTemplate( "/view/index.html" );
        	/*  create a context and add data */
        	context.put("params", params);
	        /* now render the template into a StringWriter */
	        StringWriter writer = new StringWriter();
	        t.merge( context, writer );
	        /* show the World */
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().print(writer.toString());
		} catch (Exception e) {
			super.doGet(request, response);
		}    	
    }
	
}