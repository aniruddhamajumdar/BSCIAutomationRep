package com.BSC.framework.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    public class ReadWriteExcel {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static org.apache.poi.ss.usermodel.Cell Cell;
                private static XSSFRow Row;
                private static Sheet Sheet;
                //private static XSSFRow Row;
           
            public static void setExcelFile(String Path,String SheetName) throws Exception {
            	try {
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    Log.info("TestCase Sheet" + SheetName + "opened ");
                    
            	} catch (Exception e){
            		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
            		//DriverScript.bResult = false;
                	}
            	}
            ///Get ActionKeywords from the Excel TestCase sheet
            public static List<String> getTCKeyword(String ExcelPath,String sheetName){
            	int rowCount;
            	List<String> cellData = new ArrayList<String>();
            	
            	
            	 try{
            		 FileInputStream ExcelFile = new FileInputStream(ExcelPath);
                     ExcelWBook = new XSSFWorkbook(ExcelFile);
                     ExcelWSheet = ExcelWBook.getSheet(sheetName);
                 	//Sheet = ExcelWBook.getSheet(sheetName);
                     System.out.println("No of Sheets"+ ExcelWBook.getNumberOfSheets());
                 	System.out.println("SHEET IS:"+ExcelWSheet );
                 	  System.out.println("LastRow"+ ExcelWSheet.getLastRowNum());
                 	    System.out.println("FirstRow"+ ExcelWSheet.getFirstRowNum());
                 	rowCount =ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
        			Log.info("No of rows of data for test case sheet:" + ExcelWSheet + rowCount );
        			
                	for (int i = 0; i < rowCount+1; i++) {

                        //Row row = Sheet.getRow(i);
                    	Cell = ExcelWSheet.getRow(i).getCell(3);
                        cellData.add(Cell.getStringCellValue());
                        Log.info("Cell data for given test case sheet for Keywords column is :" + ExcelWSheet + Cell.getStringCellValue());
                	}
                  }catch (Exception e){
                      Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
                      //DriverScript.bResult = false;
                      
                      }
                  
            	
				return cellData;
            	
            	
            }
            
                        ///Get Test Cases SheetNames
            public static List<String> getTCKeyword1(String path,int colNum ) throws Exception{
            	List<String> sheetNames = new ArrayList<String>();
            	List<String> keywords = new ArrayList<String>();
            	int rowCount;
            	try {
                    FileInputStream ExcelFile = new FileInputStream(path);
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    
                    for (int i=0; i<ExcelWBook.getNumberOfSheets(); i++) {
                        sheetNames.add( ExcelWBook.getSheetName(i) );
                    }
                    for(String sheet:sheetNames) {
                    	ExcelWSheet = ExcelWBook.getSheet(sheet);
            			rowCount =ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
            			Log.info("No of rows of data for test case sheet:" + ExcelWSheet + rowCount );
            			keywords=getCellData1(ExcelWSheet,rowCount,colNum);
            		}
                   
                    
            	} catch (Exception e){
            		Log.error("Test Cases do not exist in the Workbook at location: "+ path +e.getMessage());
            		//DriverScript.bResult = false;
                	}
            	return keywords;
				//getTestSteps(sheetNames,colNum);
            	}
            public static List<String> getCellData1(XSSFSheet ExcelWSheet, int rowCount, int colNum) {
				// TODO Auto-generated method stub
            	List<String> cellData = new ArrayList<String>();
            	for (int i = 0; i < rowCount+1; i++) {

                    //Row row = Sheet.getRow(i);
                	Cell = ExcelWSheet.getRow(i).getCell(colNum);
                    cellData.add(Cell.getStringCellValue());
                    Log.info("Cell data for given test case sheet for Keywords column is :" + ExcelWSheet + Cell.getStringCellValue());
            	}
				return cellData;

                    //Create a loop to print cell values in a row

			}
            
            
            ///Iterate over the teststeps for each TestCase Sheet
            public static String TCNames(String path) throws Exception{
            	List<String> sheetNames = new ArrayList<String>();
            	String sheet=null;
            
            	try {
                    FileInputStream ExcelFile = new FileInputStream(path);
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    
                    for (int i=0; i<ExcelWBook.getNumberOfSheets(); i++) {
                        sheetNames.add( ExcelWBook.getSheetName(i) );
                        
                    }
                   
                   for(String sheet1:sheetNames) {
                	   Log.info("Test Case sheet name is " + sheet);
                	   System.out.println("Test Case sheet name is" + sheet);
                	   sheet=sheet1;
                	   
                   }
                  
                    
            	} catch (Exception e){
            		Log.error("Test Case Sheet does not exist at given location: "+ path +e.getMessage());
            		//DriverScript.bResult = false;
                	}
            	return sheet;
            }
            	
            /*
            
			public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
                try{
                	ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                    String CellData = Cell.getStringCellValue();
                    return CellData;
                 }catch (Exception e){
                     Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
                     //DriverScript.bResult = false;
                     return"";
                     }
                 }
            
        	
        	public static int getRowCount(String SheetName){
        		int iNumber=0;
        		try {
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			iNumber=ExcelWSheet.getLastRowNum()+1;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			//DriverScript.bResult = false;
        			}
        		return iNumber;
        		}
        	
        	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
        		int iRowNum=0;	
        		try {
        		    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			int rowCount = ReadWriteExcel.getRowCount(SheetName);
        			for (; iRowNum<rowCount; iRowNum++){
        				if  (ReadWriteExcel.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}       			
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			DriverScript.bResult = false;
        			}
        		return iRowNum;
        		}
        	
        	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
        		try {
	        		for(int i=iTestCaseStart;i<=ReadWriteExcel.getRowCount(SheetName);i++){
	        			if(!sTestCaseID.equals(ReadWriteExcel.getCellData(i, Constants.Col_TestCaseID, SheetName))){
	        				int number = i;
	        				return number;      				
	        				}
	        			}
	        		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	        		int number=ExcelWSheet.getLastRowNum()+1;
	        		return number;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			DriverScript.bResult = false;
        			return 0;
                }
        	}
        	
        	/*
        	@SuppressWarnings("static-access")
        	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
                   try{
                	   
                	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
                       Row  = ExcelWSheet.getRow(RowNum);
                       Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                       if (Cell == null) {
                    	   Cell = Row.createCell(ColNum);
                    	   Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
                         FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
                         ExcelWBook.write(fileOut);
                         //fileOut.flush();
                         fileOut.close();
                         ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
                     }catch(Exception e){
                    	 DriverScript.bResult = false;
              
                     }
                }
*/
    	}
