package ca.company.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.jdbc.core.JdbcTemplate;

import ca.company.app.dto.CertificatesDto;
import ca.company.app.model.Certificate;

@Path("/rest")
public class CertificateService {
	
	@Path("rtq/{rtqId}/testcerts")
	@GET
	@Produces("application/json")
	public List<Certificate> getAllCertificates(@PathParam("rtqId") Long rtqId){
		
		Certificate cert;
		List<Certificate> certs = new ArrayList<Certificate>();
		
		cert = new Certificate();
		cert.setNumber(1);
		cert.setFirstName("Steve");
		cert.setLastName("Smith");
		cert.setAge(40);
		cert.setRtqId(rtqId);
		certs.add(cert);
		
		cert = new Certificate();
		cert.setNumber(2);
		cert.setFirstName("Bob");
		cert.setLastName("Smith");
		cert.setAge(40);		
		cert.setRtqId(rtqId);
		certs.add(cert);

		return certs;
		
	}
	
	@Path("/cert")
	@GET
	@Produces("application/json")
	public Certificate getCertificate(){
		
		
		Certificate cert = new Certificate();
		cert.setNumber(1);
		cert.setFirstName("Steve");
		cert.setLastName("Smith");
		cert.setAge(40);		
		
	
		return cert;
		
	}
	
	@Path("rtq/{rtqId}/certificates")
	@GET
	@Produces("application/json")
	public List<Map<String,Object>> getCertificatesForRtq(@PathParam("rtqId") Long rtqId){
		
		JdbcTemplate select = new JdbcTemplate(lookupDatasource());
		Object[] args = {rtqId};
		List<Map<String,Object>> result =  select.queryForList("SELECT * FROM  certificate WHERE rtq_id = ?", args);
		
		return result;
		
	}

	private DataSource lookupDatasource() {
		
		DataSource datasource = null;
		
	      // create InitialContext obj  
        InitialContext ic;
		try {
			ic = new InitialContext();
	        // get DataSoruce obj ref from registry  
			datasource =(DataSource)ic.lookup("java:jboss/datasources/MysqlDS"); 
	         //DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/MySqlDS");  
		} catch (NamingException e) {
			e.printStackTrace();
		} // represents conectivity with registry s/w  
		
		if (datasource == null){
			System.out.println("Datasource is null");
		} else{
			System.out.println("Datasource is NOT null");
			
		}
	    return datasource;
	}
	

}
