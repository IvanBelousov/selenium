package radioButtonTest;

import browser.Browser;
import constant.CategoryCards;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.main_pages.MainPage;
import pages.demoqa.secondPage.LeftPanel;
import pages.elements.RadioButtonPage;

public class RadioButtonTest1 {
    private WebDriver driver;
    private LeftPanel leftPanel;
    private RadioButtonPage radioButtonPage;

    @BeforeClass
    public void beforeClass() {
        driver = Browser.createDriver();
        leftPanel = new LeftPanel(driver);
        radioButtonPage = new RadioButtonPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void step_01() {
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton("Yes");
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Yes"));
    }

    @Test
    public void step_02() {
        radioButtonPage.openRadioButtonPage();
        radioButtonPage.clickRadioButton("Impressive");
        Assert.assertFalse(radioButtonPage.getStateRadioButton("Yes"));
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Impressive"));
        Assert.assertFalse(radioButtonPage.radioButtonIsEnabled("No"));
    }
}
