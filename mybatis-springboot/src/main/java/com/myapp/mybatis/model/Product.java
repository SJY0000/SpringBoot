package com.myapp.mybatis.model;

public class Product {

	private Long prodId;	// cammelcase 소문자 다음을 대문자로
	private String prodName; // DB에는 prod_id, prod_name, prod_price
	private int prodPrice;
	
	public Product(Long prodId, String prodName, int prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	// id는 자동생성이므로 제외하고 constructor
	public Product(String prodName, int prodPrice) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
	
}
