package com.test.productcatolog;

public class Product {
	 private int id;
	 private String name;
	 private String description;
	 private double price;
	 private int category_id;
	 public Product() {
		 
	 }
	 public Product(int id, String name, String description, double price,int category_id) {
	     this.id = id;
	     this.name = name;
	     this.description = description;
	     this.price = price;
	     this.category_id = category_id;
	 }
	 public int getId() {
	       return id;
	 }
	 public void setId(int id) {
		 this.id=id;
	 }
	 public String getName() {
	      return name;
	 }

	 public void setName(String name) {
	      this.name = name;
	 }

	 public String getDescription() {
	      return description;
	 }

	 public void setDescription(String description) {
	     this.description = description;
	 }

	 public double getPrice() {
	     return price;
	 }

	 public void setPrice(double price) {
	     this.price = price;
	 }

	 public int getCategory() {
	      return category_id;
	 }

	 public void setCategory(int category) {
	      this.category_id = category;
	 }
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category_id=" + category_id + "]";
	}
	 
}