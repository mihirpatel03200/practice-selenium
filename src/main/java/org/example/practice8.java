package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class practice8 {

    public static void main(String[] args) throws URISyntaxException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000)");

        List < WebElement > link = driver.findElements(By.cssSelector("li[class = 'gf-li'] a"));
        for (WebElement links : link) {

            String url = links.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode > 400 ) {
                System.out.println("This link is broken: " +links.getText() + " and the response code is :-" +responseCode);
            }
        }
//        List<WebElement> links = driver.findElements(By.cssSelector("li[class = 'gf-li'] a"));
//        for (WebElement link : links) {
//
//            String url = link.getAttribute("href");
//            HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
//            connection.setRequestMethod("HEAD");
//            connection.connect();
//            int statusCode = connection.getResponseCode();
//            System.out.println(statusCode);
//            if (statusCode >= 400) {
//                System.out.println("This link is not working : - " + link.getText() + " it is Broken with responses " + statusCode);
//                Assert.assertTrue(true);
//            }
//        }
    }
}
