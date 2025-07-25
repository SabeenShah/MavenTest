package testSce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	@Test(priority=1)
	public void mouseHover()
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	WebElement drag=driver.findElement(By.id("draggable"));
	WebElement drop=driver.findElement(By.id("droppable"));
	Actions action=new Actions(driver);
	action.dragAndDrop(drag,drop).build().perform();
	//action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	driver.quit();
	}
	@Test(priority=2,enabled=false)
	public void datePicker()
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	Integer exp_yr=2026 ;
	driver.findElement(By.id("datepicker")).click();
	while(true)
	{
		String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
		String act_yr=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
		System.out.println(month+"\t"+act_yr);
		if (act_yr.equals(String.valueOf(exp_yr)) && month.equals("June"))
				{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();
			break;			
				}
		if (exp_yr<2025)
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
		}
		else
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
		}
		
		driver.quit();
	}
	}
}
		
		
	
	
	
	
	
	
	

