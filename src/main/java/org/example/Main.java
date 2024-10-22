package org.example;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        String xpathCard = "//h5[text()='Elements']";
        WebElement card = driver.findElement(By.xpath(xpathCard));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        WebElement textBoxItem = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxItem.click();
        //WebElement h1 = driver.findElement(By.xpath("//h1[text()='Text Box']"));
        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("User1");
        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("user1@1.com");
        WebElement curAddress = driver.findElement(By.id("currentAddress"));
        curAddress.sendKeys("Moscow");
        WebElement permAddress = driver.findElement(By.id("permanentAddress"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", permAddress);
        permAddress.sendKeys("Kursk");
        WebElement button = driver.findElement(By.id("submit"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", permAddress);
        button.click();
        WebElement user = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String getUser = user.getText();
        String getEmail = email.getText();
        String getCurAddr = currentAddress.getText();
        String getPermAddr = permanentAddress.getText();
        System.out.println(getUser + "\n" + getEmail + "\n" + getCurAddr + "\n" + getPermAddr);
        driver.quit();


        
    }
}