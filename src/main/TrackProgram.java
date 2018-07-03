package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// jar files added for pdf and excel communication
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import individualRunner.IndividualRunner;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TrackProgram {
	
	// excel file
	public static final String FILE = "C:\\Users/Pervis/Documents/Jordan Stuff/Runners.xls";
	
	public static void main(String[] args) {

		try {
			
			// making workook and sheet to access information from excel sheet
			Workbook workbook = Workbook.getWorkbook(new FileInputStream(FILE));
			Sheet mainSheet = workbook.getSheet("Main");
			
			ArrayList<IndividualRunner> runners = new ArrayList<IndividualRunner>();
			
			// test to make sure that information is being gathered and collected from excel sheet
			// lines 41 - 62
			String rName = "";
			String rEvent = "";
			String rTime = "";
			double dblRTime = 0;
			
			for (int i = 1; i < mainSheet.getRows(); i++) {
				for (int k = 0; k < mainSheet.getColumns(); k++) {
					if (k == 0) {
						rName = mainSheet.getCell(k, i).getContents();
					} 
					else if (k == 1) {
						rEvent = mainSheet.getCell(k, i).getContents();
					}
					else if (k == 2) {
						rTime = mainSheet.getCell(k, i).getContents();
					}
				}
				
				//IndividualRunner tempRunner = new IndividualRunner(rName, rEvent, rTime);
				System.out.println("Runner Name: " + rName + " Runner Event: " + rEvent + " Runner Time: " + rTime);
				
			}
		
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
