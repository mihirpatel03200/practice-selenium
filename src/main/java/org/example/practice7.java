package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class practice7 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("iframe")).size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector(".dropdown-toggle"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text() = 'Courses']")).click();
        js.executeScript("window.scrollBy(0,1000)");


    }
}
