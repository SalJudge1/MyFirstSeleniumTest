package com.practice.webdriver;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;


/*
*  This test verifies the 'member login':
*  Testing an invalid id/password produces a Permission Denied
*   message.
*
 */
public class MyFirstTest {
    @Test
    public void startWebDriver() {

        //Using the Chrome webdriver, go to USA Gymnastics web page

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.usagym.org");


        // Wait 10 seconds for page to load, then Click the member login
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.className("memberLogin"));
        element.click();


        /*
        The login Modal opens.
        Find the user name and password fields.  Send bogus id and password.
        Verify the login fails & notifies the user.
         */
        WebElement loginModal = driver.findElement(By.id("loginPopUp"));
        WebElement userTxt = loginModal.findElement(By.name("user"));
        WebElement passTxt = loginModal.findElement(By.name("pass"));
        userTxt.sendKeys("AnyUserName");
        passTxt.sendKeys("pass1234");

       // Use xpath (from the login window) to find the Login button
        WebElement lognBtn = loginModal.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/descendant::span[text()='Login']"));
        lognBtn.click();

        // Hold the window a few seconds so that we can see the Permission Denied message
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the modal is Permission Denied Modal displays and just print its message to sysout.
       WebElement loginMsg = driver.findElement(By.id("ui-dialog-title-flashContainer"));
       System.out.println( loginMsg.getText());

        // Close current window and any other windows.
        driver.close();
        driver.quit();
    }

}