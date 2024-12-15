package com.CRM.QA.utils;

import com.CRM.QA.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtils extends TestBase {
   public static long page_load_timeout = 20;
   public static long implicit_wait = 10;

   public static String TESTDATA_SHEET_PATH =
           "C:\\Users\\shiv\\java_workspace\\Selenium\\POM_project_CRM\\src\\main\\java\\com\\CRM\\QA\\testData\\contact_data_CRM.xlsx";

   static Workbook book;
   static Sheet sheet;

   // Method to switch to a frame
   public void switchToFrame(String frameName) {
      driver.switchTo().frame(frameName);
   }

   // Method to fetch test data from Excel
   public static Object[][] getTestData(String sheetName) {
      FileInputStream file = null;
      try {
         file = new FileInputStream(TESTDATA_SHEET_PATH);
         System.out.println("File loaded successfully: " + TESTDATA_SHEET_PATH);
      } catch (FileNotFoundException e) {
         System.err.println("Error: Excel file not found at path: " + TESTDATA_SHEET_PATH);
         e.printStackTrace();
         return null;
      }

      try {
         book = WorkbookFactory.create(file);
         System.out.println("Workbook loaded successfully.");
      } catch (IOException e) {
         System.err.println("Error: Unable to load the workbook.");
         e.printStackTrace();
         return null;
      }

      // Debugging: Print all sheet names
      System.out.println("Available Sheets:");
      for (int i = 0; i < book.getNumberOfSheets(); i++) {
         System.out.println(book.getSheetName(i));
      }

      sheet = book.getSheet(sheetName);
      if (sheet == null) {
         System.err.println("Error: Sheet \"" + sheetName + "\" not found in the workbook.");
         return null;
      }

      int rowCount = sheet.getLastRowNum();
      int colCount = sheet.getRow(0).getLastCellNum();
      Object[][] data = new Object[rowCount][colCount];

      // Read the data
      for (int i = 0; i < rowCount; i++) {
         for (int k = 0; k < colCount; k++) {
            try {
               if (sheet.getRow(i + 1) != null && sheet.getRow(i + 1).getCell(k) != null) {
                  data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
               } else {
                  data[i][k] = ""; // Handle null cells
               }
            } catch (Exception e) {
               System.err.println("Error reading cell [" + i + "][" + k + "]: " + e.getMessage());
               data[i][k] = "";
            }
         }
      }

      try {
         file.close();
         System.out.println("File input stream closed successfully.");
      } catch (IOException e) {
         System.err.println("Error: Unable to close the file input stream.");
         e.printStackTrace();
      }

      return data;
   }

}

