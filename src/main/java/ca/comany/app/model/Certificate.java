package ca.comany.app.model;

import javax.xml.bind.annotation.XmlTransient;

public class Certificate {
	
	private Long id;
	private Long rtqId;
	private Rtq rtq;
	private Integer number = null;
	private String firstName;
	private String lastName;
	private Integer age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRtqId() {
		return rtqId;
	}
	
	public void setRtqId(Long rtqId) {
		this.rtqId = rtqId;
		if(rtqId==null){
			rtq=null;
		} else if(rtq != null && rtq.getId() != rtqId){
			rtq = null;
		}
	}
	
	@XmlTransient
	public Rtq getRtq() {
		return rtq;
	}
	
	public void setRtq(Rtq rtq) {
		this.rtq = rtq;
		if(rtq == null){
			rtqId = null;
		} else {
			rtqId = rtqId;
		}
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	


}
