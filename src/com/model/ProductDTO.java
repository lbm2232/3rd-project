package com.model;

public class ProductDTO {
	
	private int product_num;
	private String product_name;
	private String product_img;
	private int categry_num;
	private int member_num;
	

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductDTO(int product_num, String product_name, String product_img, int categry_num) {
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_img = product_img;
		this.categry_num = categry_num;
	
	}
	public ProductDTO(int product_num,String product_name, String product_img){
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_img = product_img;
	}
	
	
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public int getCategry_num() {
		return categry_num;
	}
	public void setCategory_num(int categry_num ) {
		this.categry_num = categry_num;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [product_num=" + product_num + ", product_name=" + product_name + ", product_img="
				+ product_img + ", categry_num=" + categry_num + "]";
	}
	
}
