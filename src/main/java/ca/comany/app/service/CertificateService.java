package ca.comany.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ca.comany.app.model.Certificate;

@Path("/rest")
public class CertificateService {
	
	@Path("/certificates")
	@Produces("application/app+json")
	public List<Certificate> getAllCertificates(){
		
		Certificate cert;
		List<Certificate> certs = new ArrayList<Certificate>();
		
		cert = new Certificate();
		cert.setNumber(1);
		cert.setFirstName("Steve");
		cert.setLastName("Smith");
		cert.setAge(40);		
		certs.add(cert);
		
		cert = new Certificate();
		cert.setNumber(2);
		cert.setFirstName("Bob");
		cert.setLastName("Smith");
		cert.setAge(40);		
		certs.add(cert);

		return certs;
		
	}

}
