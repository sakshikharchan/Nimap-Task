package org.techhub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long p_id;
	private String p_name;
	private Double p_price;
	
	@ManyToOne
	 @JoinColumn(name = "category_id", nullable = false)
    private Category category;

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Double getP_price() {
		return p_price;
	}

	public void setP_price(Double p_price) {
		this.p_price = p_price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long p_id, String p_name, Double p_price, Category category) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
