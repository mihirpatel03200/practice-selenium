package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class practice3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set <String> windows = driver.getWindowHandles();
        Iterator <String> it = windows.iterator(); //creating the parent and child id tabs
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());

        String eamilID = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentWindow);

        driver.findElement(By.id("username")).sendKeys(eamilID);








    }
}
