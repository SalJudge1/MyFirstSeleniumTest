package com.practice.webdriver;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.className;


/*
*  This test verifies the 'member login':
*  Testing an invalid id/password produces a Permission Denied
*   message.
*
 */
public class MyFirstTest {

    private WebDriver driver;
    private static final String USER_ID = "AnyUserName";
    private static final String PASSWD = "pass1234";

    @Before
    public void startWebDriver() {

        //Using the Chrome webdriver, go to USA Gymnastics web page

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.usagym.org");


        /*   Explicit wait ...
        *   Wait for the 'memberLogin' element to be present. If not present within timeout of 5 seconds, test will fail.
        */
        WebElement element = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(className("memberLogin")));
        element.click();
    }
    @Test
        public void testLogin() {
        /*
        The login Modal opens.
        Find the user name and password fields.  Send bogus id and password.
        Verify the login fails & notifies the user.
         */
            WebElement loginModal = driver.findElement(By.id("loginPopUp"));
            WebElement userTxt = loginModal.findElement(By.cssSelector("input[name=user]"));
            WebElement passTxt = loginModal.findElement(By.name("pass"));
            userTxt.sendKeys(USER_ID);
            passTxt.sendKeys(PASSWD);



        //  Using CssSelector to find login Button
          WebElement lognBtn =  driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button:nth-child(2)"));
          lognBtn.click();






            // Explict wait for 'Permission Denied' Modal.  Then print the message to sysout.
            WebDriverWait wait = (new WebDriverWait(driver, 5));
            WebElement loginMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-dialog-title-flashContainer")));

            System.out.println(loginMsg.getText());
        }

        @After
        public void closeUp(){
        // Close current window and any other windows.
            driver.close();
            driver.quit();
    }

}