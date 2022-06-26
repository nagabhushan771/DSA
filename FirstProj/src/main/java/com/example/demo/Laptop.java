package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")
/*
 * by default the object created of this class will have the name same as class name with lower case letters
 * we can give the name explicitly by giving the name after the component anotation like
 * @Component("name");
 */
public class Laptop {
	private int lid;
	private String lBrand;
	public int getLid() {
		return lid;
	}
	public String getlBrand() {
		return lBrand;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public void setlBrand(String lBrand) {
		this.lBrand = lBrand;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lBrand=" + lBrand + "]";
	}
	
	public void compile() {
		System.out.println("Compiling..!");
	}
}
