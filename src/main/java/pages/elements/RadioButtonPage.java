package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/radio-button";
    public static final String RADIO_BUTTON_XPATH = "//input[@type='radio'][following-sibling::label[contains(., '%s')]]";
    public static final String RADIO_BUTTON_CLICK_XPATH = "//input[@type='radio']/following-sibling::label[contains(., '%s')]";

    public void openRadioButtonPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    public boolean getStateRadioButton(String radioButtonName){
        return getRadioButtonState(By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName)));
    }

    public void clickRadioButton(String radioButtonName){
        setRadioButton(By.xpath(String.format(RADIO_BUTTON_CLICK_XPATH,radioButtonName)));
    }
    public boolean radioButtonIsEnabled(String radioButtonName){
        return isElementEnabled(By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName)));
    }
}
