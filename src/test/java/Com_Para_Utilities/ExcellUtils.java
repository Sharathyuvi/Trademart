package Com_Para_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtils {

	
	// Script to identify the Excell sheet
	public static FileInputStream fi;	//it will convert into reading mode
	public static FileOutputStream fo;	//it will convert into Writing mode
	public static XSSFWorkbook wo;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//get the row count from the excell
		public static int getRowCount(String XLFile,String XLSheet) throws IOException {
			fi = new FileInputStream(XLFile);
			wo = new XSSFWorkbook(fi);  // workbook is coming from excellsheet
			sheet = wo.getSheet(XLSheet); 
			int rowcount = sheet.getLastRowNum();
			
			wo.close();
			fi.close();
			return rowcount;
		}

		//get the cell count
		public static int getcellcount(String XLFile,String XLSheet,int rownum) throws IOException {
			fi = new FileInputStream(XLFile);
			wo = new XSSFWorkbook(fi);
			sheet = wo.getSheet(XLSheet);
			row = sheet.getRow(rownum);   // Row is inside sheet
			int cellcount = row.getLastCellNum();	//find the cell count
			
			
			wo.close();
			fi.close();
			return cellcount;
		}
		
		// to get the cell data 
		
		public static String getcelldata(String XLFile,String XLSheet,int rownum,int cellnum) throws IOException  {
			fi = new FileInputStream(XLFile);
			wo = new XSSFWorkbook(fi);
			sheet = wo.getSheet(XLSheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			
			String data;
			
			try {
//			data = cell.toString();  // to.String() is used to call data into console for Sting value only 
			
			// To call any type of date into console use dataformatter
			DataFormatter formater = new DataFormatter();
			String celldata = formater.formatCellValue(cell);
			return celldata;
			}
			catch(Exception e)
			{
				data = "";   // it stores null data 			
				}
			
				wo.close();
				fi.close();
			return data;
}
		//set cell data
		public void setcelldata(String XLFile,String XLSheet,int rownum,int cellnum,String data) throws IOException {
			fi = new FileInputStream(XLFile);
			wo = new XSSFWorkbook(fi);
			sheet = wo.getSheet(XLSheet);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			cell.setCellValue(data);
			
			fo = new FileOutputStream(XLFile);
			wo.write(fo);
			fi.close();
			fo.close();
			
		}

}
