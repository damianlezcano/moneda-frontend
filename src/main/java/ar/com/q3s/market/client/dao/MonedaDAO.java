package ar.com.q3s.market.client.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.q3s.market.client.model.Moneda;
import ar.com.q3s.market.client.model.EntityDomain;

public class MonedaDAO implements DAO{

	String uri = null; //"http://localhost:4200/rest/currency/1.8";
	
	public MonedaDAO() {
		uri = System.getenv("uri");
	}
	
	@Override
	public List<EntityDomain> list(Class<?> clazz) {
		try {
			String path = "/monedas";
			String payload = invoke(null, path, "GET");
			System.out.println("## list: " + payload);
			ObjectMapper objectMapper = new ObjectMapper();
			List<EntityDomain> list = objectMapper.readValue(payload, new TypeReference<List<Moneda>>(){});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EntityDomain get(Class<?> clazz, Long id) {
		try {
			String path = "/monedas/" + id;
			String payload = invoke(null, path, "GET");
			System.out.println("## list: " + payload);
			ObjectMapper objectMapper = new ObjectMapper();
			List<EntityDomain> list = objectMapper.readValue(payload, new TypeReference<List<Moneda>>(){});
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean persist(EntityDomain entity) {
		try {
			String path = "/monedas";
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(entity);
			invoke(jsonStr, path, "POST");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean merge(EntityDomain entity) {
		try {
			String path = "/monedas/" + entity.getId();
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(entity);
			invoke(jsonStr, path, "PUT");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(Class<?> clazz, Long id) {
		try {
			String path = "/monedas/" + id;
			invoke(null, path, "DELETE");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected String invoke(String payload, String path, String method) throws Exception {
		String response = "";
		try {
			URL url = new URL(uri + path);
			
			byte[] postDataBytes = null;
			if(payload != null) {
				postDataBytes = payload.getBytes("UTF-8");				
			}
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			if(payload != null) {
				conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
				conn.getOutputStream().write(postDataBytes);				
			}
			
			int statusCode = conn.getResponseCode();
			if (statusCode >= 200 && statusCode < 400) {
				response = extract(conn.getInputStream());
			}else {
				response = extract(conn.getErrorStream());
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error en la llamada " + method);
		}
		return response;
	}

	private String extract(InputStream is) throws Exception {
		Reader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder data = new StringBuilder();
		for (int c; (c = in.read()) >= 0;) {
			data.append((char) c);
		}
		return data.toString();
	}
	
}