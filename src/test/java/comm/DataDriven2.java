package comm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Driveconect;

public class DataDriven2 {

    WebDriver driver = null;
    @BeforeClass
      public void setUp()
    {
        driver= Driveconect.connect("https://www.facebook.com/");
    }
    @Test (dataProvider = "dp")
    public void test(String userEmail, String userPass)
    {
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        WebElement login = driver.findElement(By.name("login"));

        email.clear();
        email.sendKeys(userEmail);
        pass.clear();
        pass.sendKeys(userPass);
        login.click();

        driver.navigate().back();
    }

    @DataProvider(name="dp")
    public  Object[][] getData()
    {
        ExcelReader ed = new ExcelReader("E:\\Framework_Excel\\testframework.xlsx","login");
        int rows = ed.rowCount();
        int cols = ed.colCount();

        Object obj[][] =new Object[rows-1][cols];
        for (int i = 1; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                String data = ed.getData(i, j);
                obj[i-1][j] = data;
            }
        }
        return obj;
    }
}
