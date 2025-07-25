package testSce;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CompareWebText {
	ArrayList<String> exp_data=new ArrayList<String>();
	ArrayList<String> actual_data=new ArrayList<String>();
	FileReader fr;
	BufferedReader br;
	String src="C:\\Users\\user1\\Desktop\\data1.text";
	
	@Test(priority=1)
	public void readFrmTextFile() throws IOException 
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String cont=null;
		while((cont=br.readLine())!=null)
		{
			exp_data.add(cont);
			}
		System.out.println("Expected Array List Count..."+exp_data.size());
	}
	@Test(priority=2)
	public void readFrmWeb()
	{
		WebDriver driver= new ChromeDriver(); 
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Rows="+allRows.size());
		for (int i=1;i<allRows.size();i++)
		{
			List<WebElement> allCol=allRows.get(i).findElements(By.tagName("td"));
       for (int j=0;j<allCol.size();j++)
       {
    	   //System.out.println(allCol.get(j).getText());  
    	   actual_data.add(allCol.get(j).getText());
    	     }	
		}
		System.out.println("Actual Array list count..."+actual_data.size());
		driver.quit();
	}
	@Test(priority=3)
	public void compareBoth()
	{
		for(int i=0;i<exp_data.size();i++)
		{
			if(exp_data.get(i).equals(actual_data.get(i)))
			{
				System.out.println("Item Exit...");
			}
			else
			{
				System.out.println("Item does not Exit....");
			}
		}


	}
}
