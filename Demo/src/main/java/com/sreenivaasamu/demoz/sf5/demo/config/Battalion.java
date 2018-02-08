package com.sreenivaasamu.demoz.sf5.demo.config;

public class Battalion {
	
	private String name;

	public Battalion(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Battalion [name=%s]", name);
	}
}
