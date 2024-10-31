package com.bcc.projeto.entities.enums;

public enum Level {

	NONE(0),
	BASIC(1),
	INTERMEDIATE(2),
	ADVANCED(3),
	FLUENT(4);
	
	private int code;
	
	private Level(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Level valueOf(int code) {
		for (Level value : Level.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid Level code");
	}
}
