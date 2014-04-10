package com.marketmapp.inventory;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Item {
	@Id Long id;
	private String name;
	private float price;
	private Category category;
	private String brand;
	private Integer inventory;

	public Item(){}
	public Item(String name, float price, Category category, String brand, Integer inventory){
		this.name = name;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.inventory = inventory;
	}
	
	public void setName(String name){ this.name = name; }
	public void setPrice(float price){ this.price = price; }
	public void setCategory(Category category) { this.category = category; }
	public void setInventory(Integer inventory){ this.inventory = inventory; }
	public void setBrand(String brand){ this.brand = brand; }
	
	public String getName(){ return name; }
	public float getPrice(){ return price; }
	public Category getCategory(){ return category; }
	public Integer getInventory(){ return inventory; }
	public String getBrand(){ return brand; }
	
}
