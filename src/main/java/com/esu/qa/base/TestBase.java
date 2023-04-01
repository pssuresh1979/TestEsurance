package com.esu.qa.base;

import com.esu.qa.utilities.TestUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    
    //my test code.
    public  static WebDriver driver;
    public  static Properties prop;

    public TestBase(){
       try{
           prop = new Properties();
           FileInputStream ip = new FileInputStream("C:\\Users\\sures\\IdeaProjects\\TestEsurance\\src\\main\\java\\com\\esu\\qa\\config\\config.properties");
           prop.load(ip);

       }catch(FileNotFoundException e){
           e.printStackTrace();
       }catch(IOException e){
           e.printStackTrace();
       }

    }

    public  static void initialisation(){
        String  browserName = prop.getProperty("browser");
           if(browserName.equals("chrome")){
               System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver_win32_2\\chromedriver.exe");
               driver= new ChromeDriver();
           }
           else if(browserName.equals("FF")){
               System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver_win32_2\\chromedriver.exe");
               driver = new FirefoxDriver();
           }
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
           driver.get(prop.getProperty("url"));
    }

}
