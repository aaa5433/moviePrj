package dao;

public class User {
	String id ;
	String pass ;
	String name ;
	String idNum ;
	String mail ;
	String sex ;
	String phone ;
	
	public String getId(String id) {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword(String pass) {
		return pass;
	}
	public void setPassword(String pass) {
		this.pass = pass;
	}
	public String getName(String name) {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNum(String idNum) {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getMail(String mail) {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSex(String sex) {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone(String phone) {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
