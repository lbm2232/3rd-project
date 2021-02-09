package com.model;

public class logDTO {
	private int count;
	private int member_num;
	private int product_num;
	private String product_name;

	public logDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public logDTO(int product_num, String product_name) {
		this.product_num = product_num;
		this.product_name = product_name;

	}

	public logDTO(int count, int member_num, int product_num) {
		this.count = count;
		this.member_num = member_num;
		this.product_num = product_num;

	}
	
	public logDTO( int member_num, int product_num) {
	
		this.member_num = member_num;
		this.product_num = product_num;

	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
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

	@Override
	public String toString() {
		return "logDTO [count=" + count + ", member_num=" + member_num
				+ ", product_num=" + product_num + "]";
	}

}
