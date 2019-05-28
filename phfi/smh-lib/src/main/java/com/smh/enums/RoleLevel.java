package com.smh.enums;

public enum RoleLevel {
	
	SYSTEM("System Role"),
	SUPER_ADMIN("Super Admin");
	
	private String value;
	 
	private RoleLevel(){
	}
	
    private RoleLevel(String s){
		this.value=s;
		
	}
    
	public String getValue(){
		return value;
	}

}
