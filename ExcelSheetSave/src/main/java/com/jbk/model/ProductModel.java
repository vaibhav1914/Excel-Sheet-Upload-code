package com.jbk.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductModel {
	
	
	@NotNull
	@Min(value = 1,message = "Product id greter than 1 Allowed only")
	private long productId;
	
	@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character")
	private String productName;
	@NotNull
	@Min(value=1)
	private double productCost;
	
	private CategoryModel category;
	private SupplierModel supplier;
	
	@NotNull
	@Min(value=1,message = "Product qty greter than 1 allowed")
	private int productQty;
	@NotNull
	@Min(value=0,message = "Delivery charges 0 or greter than 0 allowed")
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
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public SupplierModel getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierModel supplier) {
		this.supplier = supplier;
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
	public ProductModel(@NotNull @Min(value = 1, message = "Product id greter than 1 Allowed only") long productId,
			@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character") String productName,
			@NotNull @Min(1) double productCost, CategoryModel category, SupplierModel supplier,
			@NotNull @Min(value = 1, message = "Product qty greter than 1 allowed") int productQty,
			@NotNull @Min(value = 0, message = "Delivery charges 0 or greter than 0 allowed") int dileveryCharge) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.category = category;
		this.supplier = supplier;
		this.productQty = productQty;
		this.dileveryCharge = dileveryCharge;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", category=" + category + ", supplier=" + supplier + ", productQty=" + productQty
				+ ", dileveryCharge=" + dileveryCharge + "]";
	}
	

}
