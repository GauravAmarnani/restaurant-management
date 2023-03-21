package com.rms.service;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.rms.annotations.Validation;

@Validation
public class ExcelSheetValidation {
	
	public String isSheetStructureValid(HSSFSheet worksheet) {
		return columnTypesMatch(worksheet);
	}

	@SuppressWarnings("deprecation")
	public String columnTypesMatch(HSSFSheet worksheet) {
		Iterator<Row> itr = worksheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) 
				if(cellIterator.next().getCellType() != Cell.CELL_TYPE_STRING)
					return "a-" + (cellIterator.next().getRowIndex() + 1);
		}
		return null;
	}
}
