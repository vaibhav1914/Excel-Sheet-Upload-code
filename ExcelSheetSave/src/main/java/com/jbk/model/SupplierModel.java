package com.jbk.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SupplierModel {
	@NotNull
	@Min(value=1,message = "Invalid Id")
	private long supplierId;
	@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character")
	private String supplierName;
	
	@NotBlank(message = "City name must not be blank")
    @Pattern(regexp = "^(?!\\d).*\\S$", message = "City name must not be numeric and must not contain spaces only")
	private String city; 
	
    @Min(value = 100000, message = "Postal code must be at least 100000")
    @Max(value = 999999, message = "Postal code must be at most 999999")
  	private int postalCode;

    @NotBlank(message = "Country name must not be blank")
    @Pattern(regexp = "^(?!\\d).*", message = "Country name must not start with a numeric digit")
    private String country;


	@NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "^[1-9]\\d{9}$", message = "Mobile number must be 10 digits and not start with 0")
  	private String mobileNo;


	public SupplierModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SupplierModel(@NotNull @Min(value = 1, message = "Invalid Id") long supplierId,
			@Pattern(regexp = "^(?!\\d).*\\S$", message = "Product name cannot be null, blank, or start with a numeric character") String supplierName,
			@NotBlank(message = "City name must not be blank") @Pattern(regexp = "^(?!\\d).*\\S$", message = "City name must not be numeric and must not contain spaces only") String city,
			@Min(value = 100000, message = "Postal code must be at least 100000") @Max(value = 999999, message = "Postal code must be at most 999999") int postalCode,
			@NotBlank(message = "Country name must not be blank") @Pattern(regexp = "^(?!\\d).*", message = "Country name must not start with a numeric digit") String country,
			@NotBlank(message = "Mobile number must not be blank") @Pattern(regexp = "^[1-9]\\d{9}$", message = "Mobile number must be 10 digits and not start with 0") String mobileNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.mobileNo = mobileNo;
	}


	public long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "SupplierModel [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
}
