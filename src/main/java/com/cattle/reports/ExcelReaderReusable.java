package com.cattle.reports;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReaderReusable {

	public ExcelReaderReusable() {
	}

	public static void main(String[] args) {
		
		try{

	
		readExcelData(args[0], "SeleniumTestCaseName",
				"TestCaseExecutionFlag");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void readExcelData(String fileName, String columnName,
			String executaionFlag) throws FileNotFoundException {
		Map<String, String> testCasesAndExecutionFlagPair = new HashMap<String, String>();
		Properties testProperties = new Properties();
		Set<String> set = new HashSet<String>();
		String Value = "";
		File file = new File("./src/main/resources/tests.properties");
		
		FileOutputStream fileOut = new FileOutputStream(file);
		try {
			FileInputStream fileIn = new FileInputStream(
					"./src/main/resources/" + fileName);
			POIFSFileSystem fs = new POIFSFileSystem(fileIn);
			HSSFWorkbook filename = new HSSFWorkbook(fs);
			HSSFSheet sheet = filename.getSheetAt(0);
			Integer seleniumTestCaseNameColumnNo = null;
			Integer testCaseExecutionFlagColumnNo = null;
			Row firstRow = sheet.getRow(0);
			for (Cell cell : firstRow) {
				if (cell.getStringCellValue().equals(columnName)) {
					seleniumTestCaseNameColumnNo = cell.getColumnIndex();

				} else if (cell.getStringCellValue().equals(executaionFlag)) {
					testCaseExecutionFlagColumnNo = cell.getColumnIndex();

				}
			}

			for (Row row : sheet) {
				Cell c1 = row.getCell(seleniumTestCaseNameColumnNo);
				Cell c2 = row.getCell(testCaseExecutionFlagColumnNo);
				if (!(c1.getStringCellValue().equalsIgnoreCase(columnName) && c2
						.getStringCellValue().equalsIgnoreCase(executaionFlag))) {
					{

						if (c2.getStringCellValue().equalsIgnoreCase("NO"))
							testCasesAndExecutionFlagPair.put(
									c1.getStringCellValue(),
									c2.getStringCellValue());

					}

				}

			}

			Iterator data = testCasesAndExecutionFlagPair.entrySet().iterator();
			StringBuilder builder = new StringBuilder();
			
			
			if(testCasesAndExecutionFlagPair.size()==0){
				testProperties.setProperty("SplitTest", "Demo.java");
			}
			else{
				while (data.hasNext()) {
					Map.Entry mEntry = (Map.Entry) data.next();
					
					builder.append("**/" + mEntry.getKey().toString() + ".java"
							+ ",");

				}
				System.out.println(builder);
			testProperties.setProperty("SplitTest", builder.toString()
					.substring(0, builder.toString().length() - 1));}

			testProperties.store(fileOut, null);

			fileOut.close();
			fileIn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}