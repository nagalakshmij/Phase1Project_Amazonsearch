package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

			WebDriver driver = new ChromeDriver();
			//WebDriver driver = new FirefoxDriver();
			driver.get("https://www.amazon.in/");    

			//Maximize window
			driver.manage().window().maximize();

			//wait for browser to load - implicit
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			WebElement searchstring =driver.findElement(By.xpath("//Input[@id='twotabsearchtextbox']"));
			searchstring.sendKeys("iphone 12");
			
			WebElement searchclick =driver.findElement(By.xpath("//Input[@id='nav-search-submit-button']"));
			searchclick.click();
			
					
			//List<WebElement> data= driver.findElements(By.xpath("//h2"));
			List<WebElement> data= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			//List<WebElement> columns= driver.findElements(By.xpath("//table[@id='customers']//th"));
			System.out.println(data.size());
			for( WebElement el: data)
			{
				System.out.println(el.getText());
			}
		
			List<WebElement> prices= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			System.out.println(prices.size());
			for( WebElement el: prices)
			{
				System.out.println(el.getText());
			}
			
			for(int i=0 ;i<data.size();i++)
			{
				System.out.println(""+data.get(i).getText()+ "price is "+prices.get(i).getText());
			}
		
			 /*HashMap<String,String> values= new HashMap<String,String>();
		        
		        
		        System.out.println(data.size());
		        for (int i=0;i<=prices.size()-1;i++) {
		            if (data.get(i).getText().contains("Apple iPhone 12")) {
		            
		            values.put(data.get(i).getText(), prices.get(i).getText());
		        }
		        }
		        
		        for(Map.Entry<String, String> entry1 :values.entrySet()) 
		        {

					System.out.println(entry1.getKey() + "        "+entry1.getValue());
				} 
				*/
				driver.close();

		        }
		}


