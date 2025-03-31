package org.techhub.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long c_id;
	private String c_name;
	
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> products;

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(Long c_id, String c_name, List<Product> products) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
}
