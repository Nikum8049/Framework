package comm;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {

    String filepath;
    String filename;

    public ExcelReader(String filepath, String filename) {
        this.filepath = filepath;
        this.filename = filename;
    }


    public int rowCount()
    {

        int row=0;
        try {
        XSSFWorkbook workbook = new XSSFWorkbook(filepath);
        XSSFSheet sheet = workbook.getSheet(filename);

        row = sheet.getPhysicalNumberOfRows();

    }
         catch (IOException e)
    {
        e.printStackTrace();
    }
    return row;
    }


public int colCount()
{

    int col=0;
    try {
        XSSFWorkbook workbook = new XSSFWorkbook(filepath);
        XSSFSheet sheet = workbook.getSheet(filename);

        col = sheet.getRow(0).getPhysicalNumberOfCells();

    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    return col;
}

public String getData(int row, int col) {
    String data = null;
    try {
        XSSFWorkbook workbook = new XSSFWorkbook(filepath);
        XSSFSheet sheet = workbook.getSheet(filename);

        data = sheet.getRow(row).getCell(col).getStringCellValue();

    } catch (IOException e) {
        e.printStackTrace();
    }
    return data;


}
}