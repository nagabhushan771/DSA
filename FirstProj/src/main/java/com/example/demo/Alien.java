package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")//to create new object every time by default spring boot is of singleton design pattern 
public class Alien {
	private int aid;
	private String aName;
	private String aTech;
	@Autowired//It searches for the type of the object in the spring container
	@Qualifier("lap1")//qualifier searches for the object with the given name in the spring container
	private Laptop laptop;
	
	
	
	public Alien() {
		super();
		System.out.println("Alien created");
	}
	public int getAid() {
		return aid;
	}
	public String getaName() {
		return aName;
	}
	public String getaTech() {
		return aTech;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public void setaTech(String aTech) {
		this.aTech = aTech;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public void show() {
		System.out.println("In show");
		laptop.compile();
	}
}
