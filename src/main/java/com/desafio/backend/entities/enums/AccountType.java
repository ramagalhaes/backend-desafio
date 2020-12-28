package com.desafio.backend.entities.enums;

public enum AccountType {
	
	ADMIN(1),
	COMMON(2);
	
	private int code;

	private AccountType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static AccountType valueOf(int code) {
		for(AccountType value : AccountType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}throw new IllegalArgumentException("User permission code does not exist");
	}
}
