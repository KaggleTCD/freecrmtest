package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver webDriver;
	public static Properties properties;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener eventListener;
	public TestBase() {
		
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream("C:\\Selenium\\freecrmtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			properties.load(fileInputStream);
		}
		catch(FileNotFoundException fileNotFoundException) {
			
			fileNotFoundException.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "C://Gecko Driver//geckodriver.exe");
			webDriver = new FirefoxDriver();
		}
		// * A wrapper around an arbitrary {@link WebDriver} instance which supports registering of a
		// * {@link WebDriverEventListener}, e&#46;g&#46; for logging purposes.
		//WebEventListener is a type of WebDriverEventListener and helps in listening to the activities performed
		//by the driver. For example, before navigating to,after navigating to
		eventFiringWebDriver = new EventFiringWebDriver(webDriver);
		eventListener = new WebEventListener();
		eventFiringWebDriver.register(eventListener);
		webDriver = eventFiringWebDriver;
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		webDriver.get(properties.getProperty("url"));
	}

}
