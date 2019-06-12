package ar.com.q3s.market.client;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	
	private final static String WEB_XML_PATH = "/WEB-INF/web.xml";
	
	public void start() throws Exception {

		String portStr = System.getenv("port");
		Integer port = portStr == null ? 8080 : new Integer(portStr);
	    Server server = new Server(port);
	    WebAppContext webAppContext = new WebAppContext();
	    webAppContext.setContextPath("/");

	    /* Important: Use getResource */
	    String webxmlLocation = Main.class.getResource(WEB_XML_PATH).toString();
	    webAppContext.setDescriptor(webxmlLocation);

	    /* Important: Use getResource */
	    String resLocation = webxmlLocation.replaceFirst(WEB_XML_PATH + "$","/").toString();
	    webAppContext.setResourceBase(resLocation);
	    webAppContext.setParentLoaderPriority(true);

	    server.setHandler(webAppContext);

	    server.start();
	    server.join();
	
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.start();
	}
}
