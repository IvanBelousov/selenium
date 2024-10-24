package textBoxTest;

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
import pages.demoqa.secondPage.SecondPage;
import pages.elements.TextBoxPage;

public class TextBoxTest1 {
    private WebDriver driver;
    private MainPage mainPage;
    private TextBoxPage textBoxPage;
    private SecondPage secondPage;
    private LeftPanel leftPanel;

    private String fullName = "Belousov Ivan";
    private String email = "test@test.ru";
    private String curAddr = "Курск";
    private String permAddr = "Москва";

    @BeforeClass
    public void beforeClass() {
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        leftPanel = new LeftPanel(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void step_01() {
        mainPage.openMainPage();
        secondPage = mainPage.openCategoryCards(CategoryCards.ELEMENTS);
        Assert.assertTrue(secondPage.isPageOpen());
        Assert.assertTrue(leftPanel.isLeftPanelDisplayed());
        Assert.assertTrue(leftPanel.isBlockOpen(CategoryCards.ELEMENTS));
        textBoxPage = leftPanel.openTextBoxPage();
        Assert.assertEquals(textBoxPage.getPageName(), Item.TEXT_BOX.getName());
    }

    @Test
    public void step_02() {
        textBoxPage.setFullName(fullName);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(curAddr);
        textBoxPage.setPermanentAddress(permAddr);
        textBoxPage.clickSubmit();
        //textBoxPage.setAllFieldAndSubmit(fullName,email,curAddr,permAddr); можно использовать этот метод вместо 5 предыдущих строк
        Assert.assertEquals(textBoxPage.getOutputName(), "Name:" + fullName);// Вытаскивает значение из поля вывода и сравнивает с нашей переменной
        Assert.assertEquals(textBoxPage.getOutputEmail(), "Email:" + email);
        Assert.assertEquals(textBoxPage.getOutputCurAddr(), "Current Address :" + curAddr);
        Assert.assertEquals(textBoxPage.getOutputPermAddr(), "Permananet Address :" + permAddr);
    }
}
