package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;


/**
 * @author Subhajit
 *
 */
public class XSSFSheetUtil extends TestBase{

	public static int Page_timeout=20;
	public static long Wait_time=30;
	//	XSSFWorkbook wb = null;
	public XSSFSheet sheet1 = null;
	public String sheetName = null;
	
//	private XSSFSheetUtil(){
//		super();
//	}

	public XSSFSheetUtil(String excelfile) {
		super();
		this.excelfile = excelfile;
	}

	public XSSFWorkbook readFile() throws Exception {
		File src=new File(excelfile);
		FileInputStream fis=new FileInputStream(src);
		return new XSSFWorkbook(fis);
	}

	public String getdata(String sheetname,int row,int column) throws Exception{
		if(sheetName == null || !sheetName.equals(sheetname) || sheet1 == null ){
			XSSFWorkbook wb = readFile();
			sheetName = sheetname;
			sheet1=wb.getSheet(sheetname);
		}
		String data=sheet1.getRow(row).getCell(column).getRawValue();
		return data;
	}
	
	public static XSSFSheetUtil getXssfSheetUtil(String excelfile) {
		return new XSSFSheetUtil(excelfile);
	}
}


