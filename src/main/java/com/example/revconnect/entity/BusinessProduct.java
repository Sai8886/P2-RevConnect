package com.example.revconnect.entity;

import jakarta.persistence.*;

@Entity
public class BusinessProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    private BusinessProfile business;

    private String name;
    private String description;
    private Double price;
    private String url;

    public BusinessProduct() {}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BusinessProfile getBusiness() {
		return business;
	}

	public void setBusiness(BusinessProfile business) {
		this.business = business;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    
}