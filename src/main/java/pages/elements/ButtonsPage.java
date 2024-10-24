package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.awt.*;

public class ButtonsPage extends BasePage {
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/buttons";
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");
    public static final String MESSAGE_DOUBLE_CLICK = "You have done a double click";
    public static final String MESSAGE_RIGHT_CLICK = "You have done a right click";
    public static final String MESSAGE_CLICK = "You have done a dynamic click";

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void openButtonsPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }
    public boolean isMessageDisplay(String message){
        String xpath = "//*[text()='" + message + "']";
        return isElementDisplay(By.xpath(xpath));
    }
}
