package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage {
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }
    public static final String URL_DYNAMIC_PAGE = "https://demoqa.com/dynamic-properties";
    public static final By BTN_ENABLE_AFTER = By.id("enableAfter");
    public static final By BTN_COLOR_CHANGE = By.id("colorChange");
    public static final By BTN_VISIBLE_AFTER = By.id("visibleAfter");

    public void openDynamicPage(){
        openUrl(URL_DYNAMIC_PAGE);
    }
    public void clickBtnEnableAfter(){
        waitForElementsEnabled(BTN_ENABLE_AFTER,6);
        click(BTN_ENABLE_AFTER);
    }
    public void clickBtnVisibleAfter(){
        waitElementIsVisible(BTN_VISIBLE_AFTER,6);
        click(BTN_VISIBLE_AFTER);
    }

    public void waitForColorChange(){
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(d -> isColorChange(BTN_COLOR_CHANGE,"rgba(220, 53, 69, 1)"));
    }

    public String getColorBtn(By xpathBtn){
        return getAttributeValue(xpathBtn,"color");
    }
    public boolean isColorChange(By xpathBtn,String color){
        return getColorBtn(xpathBtn).equals(color);
    }


}
