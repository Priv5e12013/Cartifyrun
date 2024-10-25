package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartifyRun {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.cartify.pk");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        driver.findElement(By.xpath("//span[text()='Shop By Categories']")).click();
        
        driver.findElement(By.xpath("//div[contains(text(),'Cloth Rack')]")).click();
        WebElement floor = driver.findElement(By.xpath("//span[contains(text(),'Floor')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", floor);
        driver.findElement(By.xpath("//button[@name='add']")).click();
        
        driver.findElement(By.xpath("//a[contains(text(),'View')]")).click();
       
		String subtotal =driver.findElement(By.xpath("//span[@class='cart-subtotal__price']")).getText();
		System.out.println("Subtotal price:" +subtotal);
		
		driver.quit();
		
		
	}

}
