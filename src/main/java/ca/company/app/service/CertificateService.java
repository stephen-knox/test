package ca.company.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ca.company.app.dto.CertificatesDto;
import ca.company.app.model.Certificate;

@Path("/rest")
public class CertificateService {
	
	@Path("rtq/{rtqId}/certificates")
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

}
