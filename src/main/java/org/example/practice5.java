package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class practice5 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions a = new Actions(driver);
        a.scrollToElement(driver.findElement(By.id("courses-iframe"))).build().perform();
        a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
    }
}
