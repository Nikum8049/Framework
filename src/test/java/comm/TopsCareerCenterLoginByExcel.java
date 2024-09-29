package comm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Driveconect;

import java.util.Objects;

public class TopsCareerCenterLoginByExcel {
    WebDriver driver = null;

    @BeforeClass
    public void setUp()
    {
        driver= Driveconect.connect("https://careercenter.tops-int.com/");
    }

    @Test(dataProvider = "dp")
    public void test(String userName,String userPass )
    {


        WebElement username = driver.findElement(By.xpath("//input[@name='user_name']"));
        WebElement userpass = driver.findElement(By.xpath("//input[@name='user_password']"));
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));

        username.clear();
        username.sendKeys(userName);
        userpass.clear();
        userpass.sendKeys(userPass);
        login.click();
        driver.navigate().back();
    }

    @DataProvider(name = "dp")
    public Object[][] getData()
    {

        ExcelReader ed= new ExcelReader("E:\\Framework_Excel\\testframework.xlsx","TopsCareer");
        int rows = ed.rowCount();
        int cols = ed.colCount();
        Object obj [][]= new Object[rows-1][cols];
        for(int i=1; i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                String data= ed.getData(i,j);
                obj[i-1][j]= data;
            }
        }
        return obj;
    }
}
