package com.study.sb;

public class ProductVO {

	private String name;
	private double price;
	
	public ProductVO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ProductVO [ \n");
		sb.append("name = " + name + "\n");
		sb.append("price = " + price + "\n");
		
		return sb.toString();
	}
}
