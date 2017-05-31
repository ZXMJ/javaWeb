package com.pojo;

public class SearchUser {

	private String name;
	private String email;
	
	public SearchUser() {
		
	}
	public SearchUser(String name, String email) {
		setName(name);
		setEmail(email);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name==null||"".equals(name.trim())){
			this.name = "%%";
		}else{
			this.name = "%"+name+"%";
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email==null||"".equals(email.trim())){
			this.email = "%%";
		}else{
			this.email = "%"+email+"%";
		}
	}
	
}
