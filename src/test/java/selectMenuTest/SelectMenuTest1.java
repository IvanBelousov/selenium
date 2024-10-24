package selectMenuTest;

import browser.Browser;
import constant.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.DynamicPropertiesPage;
import widgets.SelectMenu;

public class SelectMenuTest1 {
    private WebDriver driver;
    private DynamicPropertiesPage dynamicPropertiesPage;
    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void step_1(){
        dynamicPropertiesPage.openUrl("https://demoqa.com/select-menu");
        Select select = new Select(dynamicPropertiesPage.findElement(By.id("cars")));
        select.selectByVisibleText("Saab");
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();

    }
}
