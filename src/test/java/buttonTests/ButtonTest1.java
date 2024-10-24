package buttonTests;

import browser.Browser;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.ButtonsPage;
import pages.elements.CheckBoxPage;

import static pages.elements.ButtonsPage.*;

public class ButtonTest1 {
    private WebDriver driver;
    private ButtonsPage buttonsPage;
    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        buttonsPage = new ButtonsPage(driver);
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void step_1(){
        buttonsPage.openButtonsPage();
        buttonsPage.doubleClick(DOUBLE_CLICK_BTN);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
    }
    @Test
    public void step_2(){
        buttonsPage.contextClick(RIGHT_CLICK_BTN);
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
    }

    @Test
    public void step_3(){
        buttonsPage.buttonClick("Click Me");
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_CLICK));
    }

}
