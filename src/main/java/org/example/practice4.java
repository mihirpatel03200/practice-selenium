package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class practice4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Clicking on the radio button.
        driver.findElement(By.xpath("//input[@value='radio2']")).click();

        //Dynamic Dropdown first search and then click on the expected dropdown
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        List < WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

        for (WebElement option : options) {
            if (option.getText().equals("India")) {
                option.click();
                break;
            }
        }

        //Select dropdown
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("option3");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option3");
        dropdown.selectByIndex(1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option1");
        dropdown.selectByVisibleText("Option2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option2");



    }
}
