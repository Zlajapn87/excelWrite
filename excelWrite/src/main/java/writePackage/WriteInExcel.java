package writePackage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import data.DataToWrite;

public class WriteInExcel {
	
			
			   public static void main(String[] args) throws Exception {
				   
				  DataToWrite dataToWrite = new DataToWrite();

			      //Create blank workbook
			      XSSFWorkbook workbook = new XSSFWorkbook();    
			      //Create a blank sheet
			      XSSFSheet spreadsheet = workbook.createSheet( " ZlajaSoftware");
			      	
			      //Create row object
			      
			//       Create a Font for styling header cells
			        Font headerFont = workbook.createFont();
			        headerFont.setBold(true);
			        headerFont.setFontHeightInPoints((short) 14);
			        headerFont.setColor(IndexedColors.RED.getIndex());
	
			        // Create a CellStyle with the font
			        CellStyle headerCellStyle = workbook.createCellStyle();
			        headerCellStyle.setFont(headerFont);
			        
			        XSSFRow row;
  		
			      //Iterate over data and write to sheet
			      Set < String > keyid = DataToWrite.getEmpinfo().keySet();
			      int rowid = 0;
			      
			      for (String key : keyid) {
			         row = spreadsheet.createRow(rowid++);
			         Object [] objectArr = DataToWrite.getEmpinfo().get(key);
			         int cellid = 0;
			         
			         for (Object obj : objectArr){
			            Cell cell = row.createCell(cellid++);
			            if ( rowid == 1  ) {
			            	cell.setCellStyle(headerCellStyle);
			            	}
			            cell.setCellValue((String)obj);
			            
			         }
			      }
			      //Write the workbook in file system
			      File file = new File("C:/poiexcel/Writesheet.xlsx");
			      FileOutputStream out = new FileOutputStream(file);
			       
			      
			      workbook.write(out);
			      out.close();
			      if (!(file.length() == 0)) {
			      System.out.println("Writesheet.xlsx written successfully ");	
			      } else System.out.println("Writesheet.xlsx is not written successfully ");
			   }	
	}