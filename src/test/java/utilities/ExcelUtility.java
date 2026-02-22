package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public ExcelUtility(String path) {

		this.path = path;

	}

	public int getRowCount(String sheetName) {
		int rowcount = 0;

		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rowcount = sheet.getLastRowNum();
			workbook.close();
			fi.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) {
		int cellcount = 0;
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cellcount = row.getLastCellNum();
			workbook.close();
			fi.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) {

		String data = "";
		DataFormatter formatter = new DataFormatter();
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			data = formatter.formatCellValue(cell); // returns the formatted value of a cell a s string
			workbook.close();
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) {

		File xlfile = new File(path);
		if (xlfile.exists()) {

			workbook = new XSSFWorkbook();
			try {
				fo = new FileOutputStream(path);
				workbook.write(fo);
				fi = new FileInputStream(path);
				workbook = new XSSFWorkbook(fi);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (workbook.getSheetIndex(sheetName) == -1) // if sheet doesnot exist then create new sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		try {
			fo = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) {

		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
		} catch (Exception e) {

		}
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillRedColor(String sheetName, int rownum, int colnum) {

		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
