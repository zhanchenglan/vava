package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class StartPage {
    protected Logger logger = Logger.getLogger("StartPage");
    public AndroidDriver driver;
    WebDriverWait wait;

    public StartPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public StartPage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        /*真机启动参数*/
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel XL");
        desiredCapabilities.setCapability("appPackage", "com.vava.ipc");
        desiredCapabilities.setCapability("appActivity", ".WelcomeActivity filter fa7a5a1");
        desiredCapabilities.setCapability("newCommandTimeout", "600000");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("udid", "HT75T0200443");
        desiredCapabilities.setCapability("adbExecTimeout", "200000");
        desiredCapabilities.setCapability("skipServerInstallation", "true");
        desiredCapabilities.setCapability("skipDeviceInitialization", "true");
        desiredCapabilities.setCapability("noReset", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait=new WebDriverWait(driver, 100);
    }

    public void click(By by){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if(by== null){
            logger.warning("by is null");
        }
        logger.info("click wait for clickable");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (RuntimeException e) {
            logger.warning("RuntimeException ocurde!");
            e.printStackTrace();
        }


    }

    public void sendkeys(By by,String keys){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(keys);
    }

    /*获取toast消息*/
    public String getToast(){
        String toastMessage=driver.findElementByXPath("//*[@class='android.widget.Toast']").getText();
        System.out.println("toastMessage:"+toastMessage);
        return toastMessage;
    }

    /*获取控件的text值*/
    public String getTextValue(By by){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String textValue=wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
        //String textValue=driver.findElement(by).getText();
        return textValue;
    }

    public void quit(){
        driver.quit();
    }


}
