package cucumber;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class add {
	static WebDriver driver;
	
	@Given("user launch the browser")
	public void user_launch_the_browser() {
	     System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\nishanth\\dri\\chromedriver.exe");
		driver=new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/");
		// driver.manage().window().maximize();
		 driver.findElement(By.xpath("((//a[text()='Add Customer'])[1])")).click();
		 driver.findElement(By.xpath("//label[text()='Done']")).click();
	}

	@When("user clcik the add customer")
	public void user_clcik_the_add_customer(DataTable details) {
	Map<String,String>CusData= details.asMap(String.class,String.class);
		System.out.println("when");
	
	driver.findElement(By.id("fname")).sendKeys(CusData.get("fname"));
	driver.findElement(By.id("lname")).sendKeys(CusData.get("lname"));
	driver.findElement(By.id("email")).sendKeys(CusData.get("email"));
	driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(CusData.get("address"));
	driver.findElement(By.id("telephoneno")).sendKeys(CusData.get("phno"));
	driver.findElement(By.xpath("//input[@name='submit']")).click();

	}
	@When("user clcik the add customer{string},{string},{string},{string},{string}")
	public void user_clcik_the_add_customer(String A,String B,String C,String D,String E) {
		
	//	System.out.println("when");
		
		driver.findElement(By.id("fname")).sendKeys(A);
		driver.findElement(By.id("lname")).sendKeys(B);
		driver.findElement(By.id("email")).sendKeys(C);
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(D);
		driver.findElement(By.id("telephoneno")).sendKeys(E);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	@When("user click the Add tariff Details.")
	public void user_click_the_Add_tariff_Details(DataTable tariffdetails) {
		Map<String,String>tariff=tariffdetails.asMap(String.class,String.class);
		System.out.println("enter the customer id");
		WebElement txt =  driver.findElement(By.tagName("h3"));
	    String cusID=txt.getText();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("((//a[text()='Add Tariff Plan to Customer'])[1])")).click();
		driver.findElement(By.id("customer_id")).sendKeys(cusID);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]")).isDisplayed());
		System.out.println("Successfully run the codes");
	}
}
