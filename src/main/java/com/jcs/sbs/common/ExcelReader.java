package com.jcs.sbs.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jcs.sbs.models.AccountType;

public class ExcelReader {

    public static Map<String, AccountType> getExcelAccountType() {
        Map<String, AccountType> result = new HashMap<String, AccountType>();
        try {
            InputStream file = ClassLoader.getSystemResourceAsStream("Production_Accounts_PMs.xlsx");

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int sheets = workbook.getNumberOfSheets();
            XSSFSheet sheet;
            for (int sheetIter = 0; sheetIter < sheets; sheetIter++) {
                sheet = workbook.getSheetAt(sheetIter);

                // Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                rowIterator.next();
                while (rowIterator.hasNext()) {
                    ArrayList<String> currentRow = new ArrayList<String>();
                    Row row = rowIterator.next();
                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        // Check the cell type and format accordingly
                        switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            currentRow.add(String.valueOf(Long.valueOf((long) cell.getNumericCellValue())));
                            break;
                        case Cell.CELL_TYPE_STRING:
                            currentRow.add(cell.getStringCellValue());
                            break;
                        }

                    }
                    if (currentRow.size() > 3) {
                        AccountType accountType = new AccountType(currentRow.get(0), currentRow.get(1),
                                currentRow.get(2), currentRow.get(3));
                        result.put(accountType.getAccountId(), accountType);
                    }
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
