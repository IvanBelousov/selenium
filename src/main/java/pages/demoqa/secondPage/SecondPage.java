package pages.demoqa.secondPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SecondPage extends BasePage {
    public SecondPage(WebDriver driver) {
        super(driver);
    }
    public static final By ZERO_STEP_PICTURE = By.xpath("//a/img[@src='/images/zero-step.jpeg']");
    public static final By PLEASE_SELECT_AN_ITEM = By.xpath("//div[text()='Please select an item from left to start practice.']");

    public boolean zeroStepPictureIsDisplayed(){
        return isElementDisplay(ZERO_STEP_PICTURE);
    }

    public boolean pleaseSelectAnItemXpathIsDisplayed(){
        return isElementDisplay(PLEASE_SELECT_AN_ITEM);
    }
    public boolean isPageOpen(){
        if (zeroStepPictureIsDisplayed() && pleaseSelectAnItemXpathIsDisplayed()){
            return true;
        }
        return false;
    }
}
