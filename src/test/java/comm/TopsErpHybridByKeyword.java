package comm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TopsErpHybridByKeyword {

    WebDriver driver=null;

    @Test(dataProvider = "dp")
    public void test(String function, String keyword, String locator, String location, String data )
    {
        System.out.println(function +" "+keyword+" "+locator+" "+location+" "+data);

    }


    @DataProvider(name="dp")
    public Object[][] getData()
    {
        ExcelReader ed = new ExcelReader("E:\\Framework_Excel\\testframework.xlsx","erp");
        int rows = ed.rowCount();
        int cols = ed.colCount();

        Object obj [][]= new Object[rows-1][cols];
        for(int i=1; i<rows;i++)
        {
            for (int j=0; j<cols; j++)
            {
                String data= ed.getData(i,j);
                obj[i-1][j]=data;
            }

        }


        return obj;
    }
}
