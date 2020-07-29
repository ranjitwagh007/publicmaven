package sovimal.olymicid.commonutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static Properties pr;
	public static String path = "G:\\Olycimid\\olymicid\\resources\\config.properties";
	public static WebDriver driver = null;

	public static Properties prop() throws IOException {

		pr = new Properties();
		FileInputStream ip = new FileInputStream(path);
		pr.load(ip);
		return pr;

	}

	@BeforeSuite
	public void setPropery() {

		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Olycimid\\olymicid\\drivers\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "G:\\Olycimid\\olymicid\\drivers\\geckodriver.exe");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void gotoUrl() {
		try {
			if (driver == null && prop().getProperty("browser").equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(prop().getProperty("url"));

			} else if (driver == null && prop().getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(prop().getProperty("url"));

			} else {
				System.out.println("set browser");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public void browserName() {
		driver.close();
	}

	@AfterSuite
	public void killinstance() throws InterruptedException {

		Thread.sleep(1000);
		driver.quit();
	}

	public static WebDriver getDriver() {

		return driver;
	}

}