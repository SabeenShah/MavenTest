package testSce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {
	@Test
	public void switchWin()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWin=driver.getWindowHandles();// set allows unique values and array list allows duplicate values
		System.out.println("Total windows open..."+allWin.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWin.iterator();
		win1=itr.next();
		win2=itr.next();
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1 title"+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title"+driver.getTitle());
		boolean chkEle=driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]/span[1]")).isEnabled();
		System.out.println(chkEle);
		if (chkEle==true)
		{
			System.out.println("Sign In button is enable and test is passed");
		}
		else
		{ 
			System.out.println("Sign In button is disable and test is failed");
		}
driver.close();
	}

}
