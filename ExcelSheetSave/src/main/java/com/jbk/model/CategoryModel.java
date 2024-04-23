package com.jbk.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoryModel {

	@NotNull
	@Min(value = 1,message = "Category id greter than 1 Allowed only")
	private long categoryId;
	@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character")
	private String categoryName;
	@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character")
	private String categoryDesc;
	@NotNull
	@Min(value = 0,message = "Discount greter than 0 or 1 Allowed only")
	private int categoryDiscount;
	
	@NotNull
	@Min(value = 0,message = "Category Gst greter than 1% or 0% Allowed only")
	private int categoryGst;

	public CategoryModel(@NotNull @Min(value = 1, message = "Category id greter than 1 Allowed only") long categoryId,
			@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character") String categoryName,
			@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character") String categoryDesc,
			@NotNull @Min(value = 0, message = "Discount greter than 0 or 1 Allowed only") int categoryDiscount,
			@NotNull @Min(value = 0, message = "Category Gst greter than 1% or 0% Allowed only") int categoryGst) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryDiscount = categoryDiscount;
		this.categoryGst = categoryGst;
	}

	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public int getCategoryDiscount() {
		return categoryDiscount;
	}

	public void setCategoryDiscount(int categoryDiscount) {
		this.categoryDiscount = categoryDiscount;
	}

	public int getCategoryGst() {
		return categoryGst;
	}

	public void setCategoryGst(int categoryGst) {
		this.categoryGst = categoryGst;
	}

	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc + ", categoryDiscount=" + categoryDiscount + ", categoryGst=" + categoryGst + "]";
	}
	
	
}
