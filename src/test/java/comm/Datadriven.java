package comm;

public class Datadriven {
    public static void main(String[] args) {

        ExcelReader ed = new ExcelReader("E:\\Framework_Excel\\testframework.xlsx", "Register");
        int rows = ed.rowCount();

        System.out.println("rows : " + rows);
        int cols = ed.colCount();
        System.out.println("cols: " + cols);


        for (int i = 1; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                String data = ed.getData(i, j);
                System.out.print(" " + data);
            }
            System.out.println(" ");
        }
    }
}
