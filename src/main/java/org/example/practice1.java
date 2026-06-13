package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class practice1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div.q7ywiQ"))));

        driver.findElement(By.cssSelector("span.b3wTlE")).click();

        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.cssSelector("span.v1zwn27"))).contextClick().build().perform();

        a.moveToElement(driver.findElement(By.xpath("//input[@title= 'Search for Products, Brands and More']"))).click().keyDown(Keys.SHIFT).sendKeys("apple").build().perform();

        



    }
}
