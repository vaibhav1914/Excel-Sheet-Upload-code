package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Product")
public class ProductEntity {
	@Id
	private long productId;
	private String productName;
	private double productCost;
	@OneToOne
	@JoinColumn(name="supplierId")
	private SupplierEntity supplier;
	@OneToOne
	@JoinColumn(name="categoryId")
	private CategoryEntity category;
	
	
	private int productQty;
	private int dileveryCharge;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public SupplierEntity getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public int getDileveryCharge() {
		return dileveryCharge;
	}
	public void setDileveryCharge(int dileveryCharge) {
		this.dileveryCharge = dileveryCharge;
	}
	public ProductEntity(long productId, String productName, double productCost, SupplierEntity supplier,
			CategoryEntity category, int productQty, int dileveryCharge) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.supplier = supplier;
		this.category = category;
		this.productQty = productQty;
		this.dileveryCharge = dileveryCharge;
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", supplier=" + supplier + ", category=" + category + ", productQty=" + productQty
				+ ", dileveryCharge=" + dileveryCharge + "]";
	}
	
	
	
}
