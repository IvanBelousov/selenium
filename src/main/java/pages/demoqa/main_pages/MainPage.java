package pages.demoqa.main_pages;
import constant.CategoryCards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.demoqa.secondPage.SecondPage;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public static final String MAIN_PAGE = "https://demoqa.com/";
    public static final By HOME_BANNER = By.xpath("//div[@class='home-banner'][a[@href='https://www.toolsqa.com/selenium-training/'][img[contains(@src,'WB.svg')]]]");

    public static final  By CATEGORY_CARDS_XPATH = By.xpath("//h5[contains(text(),'')]");
    public static final String CATEGORY_CARD_XPATH = "//h5[text()='%s']";

    public void openMainPage(){
        openUrl(MAIN_PAGE);
    }
    public SecondPage openCategoryCards(CategoryCards nameCards){
        By locator = By.xpath(String.format(CATEGORY_CARD_XPATH,nameCards.getName()));
        click(locator);
        return new SecondPage(driver);
    }
    public int getCategoryCount(){
        return getElementsCount(CATEGORY_CARDS_XPATH);
    }
}
