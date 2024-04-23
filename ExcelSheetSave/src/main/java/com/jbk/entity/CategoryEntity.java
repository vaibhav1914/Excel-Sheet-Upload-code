package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryEntity {
	@Id
	private long categoryId;
	private String categoryName;
	private String categoryDesc;
	private int categoryDiscount;
	private int categoryGst;
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryEntity(long categoryId, String categoryName, String categoryDesc, int categoryDiscount,
			int categoryGst) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryDiscount = categoryDiscount;
		this.categoryGst = categoryGst;
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
		return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc + ", categoryDiscount=" + categoryDiscount + ", categoryGst=" + categoryGst + "]";
	}

}
