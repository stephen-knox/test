package ca.company.app.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ca.company.app.model.Certificate;

@XmlRootElement
public class CertificatesDto {
	
	private List<Certificate> certs;
	
	
	public CertificatesDto(List<Certificate> certs) {
		super();
		this.certs = certs;
	}

	public List<Certificate> getCerts() {
		return certs;
	}

	public void setCerts(List<Certificate> certs) {
		this.certs = certs;
	}
	
	

}
