package com.jbk.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.RollbackException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;
import com.jbk.exceptions.ExcelSheelDataNotValid;
import com.jbk.exceptions.ResourcesAlreadyExist;
import com.jbk.exceptions.SomethingWentWrong;
import com.jbk.model.CategoryModel;
import com.jbk.model.ProductModel;
import com.jbk.model.SupplierModel;
import com.jbk.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean addProduct(ProductModel productModel) {

		return dao.addProduct(modelMapper.map(productModel, ProductEntity.class));

	}

	@Override
	public String uploadSheet(MultipartFile myfile) {
		int added = 0;
		int isExist = 0;
		int isIssue = 0;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					"excelSheets" + File.separator + myfile.getOriginalFilename());
			fileOutputStream.write(myfile.getBytes());

			List<ProductModel> excelSheetList = readExcelSheet(
					"excelSheets" + File.separator + myfile.getOriginalFilename());

			for (ProductModel productModel : excelSheetList) {
				ProductEntity productEntity = modelMapper.map(productModel, ProductEntity.class);
				try {
					boolean isAdded = dao.addProduct(productEntity);
					if (isAdded) {
						added = added + 1;
					}

				}

				catch (ResourcesAlreadyExist e) {
					isExist = isExist + 1;
				}
			}

		} catch (Exception e) {
			isIssue = isIssue + 1;
		}
		return "Added : " + added + " Is Exist : " + isExist + " Issue : " + isIssue;
	}

	public List<ProductModel> readExcelSheet(String file) throws ExcelSheelDataNotValid {
		List<ProductModel> list = new ArrayList<>();

		Map<String, String> fieldErrorMap = new HashMap<>();
		HashMap<Object, Map<String, String>> map = new HashMap<>();

		// fieldErrorMap.put("A", "A");
		boolean isvalid = true;
		try {
			// file Point Out
			FileInputStream fileInputStream = new FileInputStream(file);
			// workbook Point Out
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			// sheet point out
			Sheet sheet = workbook.getSheetAt(0);
			// rows point out
			Iterator<Row> rows = sheet.rowIterator();
			// iterate rows
			while (rows.hasNext()) {
				// each row
				Row row = (Row) rows.next();
				int rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}

				// iterate cells
				Iterator<Cell> cells = row.cellIterator();
				ProductModel productModel = new ProductModel();

				while (cells.hasNext()) {
					// each cell
					Cell cell = (Cell) cells.next();
//					byte errorCellValue = cell.getErrorCellValue();
					// System.out.println(cell.toString());
					int columnIndex = cell.getColumnIndex();
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
					productModel.setProductId(Long.parseLong(timeStamp + rowNum));

					switch (columnIndex) {
					case 0: {

						String productName = cell.getStringCellValue();
						productModel.setProductName(productName);
						break;
					}
					case 1: {
						double supplierId = cell.getNumericCellValue();
						SupplierModel supplierModel = new SupplierModel();
						supplierModel.setSupplierId((long) supplierId);
						productModel.setSupplier(supplierModel);

						break;
					}
					case 2: {
						double categoryId = cell.getNumericCellValue();
						CategoryModel categoryModel = new CategoryModel();
						categoryModel.setCategoryId((long) categoryId);
						productModel.setCategory(categoryModel);

						break;
					}
					case 3: {
						double productQty = cell.getNumericCellValue();
						productModel.setProductQty((int) productQty);

						break;
					}
					case 4: {
						double productprice = cell.getNumericCellValue();
						productModel.setProductCost(productprice);

						break;
					}
					case 5: {
						double deliveryCharges = cell.getNumericCellValue();

						productModel.setDileveryCharge((int) deliveryCharges);

						break;
					}

					}

				}
				//System.out.println(productModel);
				if (productModel.getProductName().isEmpty() || productModel.getProductName() == null) {
					fieldErrorMap.put("Product Name", "Product name is required.");
					isvalid = false;
				} else if (productModel.getSupplier().getSupplierId() <= 0) {
					fieldErrorMap.put("Supplier Id", "Supplier ID must be greater than 0.");
					isvalid = false;
				} else if (productModel.getCategory().getCategoryId() <= 0) {
					fieldErrorMap.put("Category Id", "Category ID must be greater than 0.");
					isvalid = false;
				} else if (productModel.getProductQty() <= 0) {
					fieldErrorMap.put("Product Quantity", "Quantity must be greater than 0.");
					isvalid = false;
				} else if (productModel.getProductCost() <= 0.0) {
					fieldErrorMap.put("Product Cost", "Product Price must be greater than 0.");
					isvalid = false;
				} else if (productModel.getDileveryCharge() <= 0) {
					fieldErrorMap.put("Delivery Charges", "Delivery Charge must be greater than 0.");
					isvalid = false;
				}

				if (isvalid) {
					list.add(productModel);
				} else {

					throw new ExcelSheelDataNotValid(fieldErrorMap);

				}
				   
			}

		}

		catch (Exception e) {
			throw new SomethingWentWrong("something went wrong ");
		}
		return list;
	}

}
