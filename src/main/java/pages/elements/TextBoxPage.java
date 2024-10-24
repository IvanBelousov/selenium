package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/text-box";
    public static final String INPUT_XPATH = "//*[@placeholder='%s']";
    public static final String PERMANENT_ADDRESS = "//textarea[@id='permanentAddress']";
    public static final String SUBMIT = "//button[@id='submit']";
    public static final String OUTPUT_XPATH = "//div[@id='output']//p[@id='%s']";

    public static final String FULL_NAME = "Full Name";
    public static final String EMAIL = "name@example.com";
    public static final String CURRENT_ADDRESS = "Current Address";


    public TextBoxPage openTextBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
        return new TextBoxPage(driver);
    }
    public void setFullName(String text) {
        String locator = String.format(INPUT_XPATH, FULL_NAME);
        sendKeys(By.xpath(locator), text);
    }

    public void setEmail(String email) {
        String locator = String.format(INPUT_XPATH, EMAIL);
        sendKeys(By.xpath(locator), email);
    }

    public void setCurrentAddress(String address) {
        String locator = String.format(INPUT_XPATH, CURRENT_ADDRESS);
        sendKeys(By.xpath(locator), address);
    }

    public void setPermanentAddress(String address) {

        sendKeys(By.xpath(PERMANENT_ADDRESS), address);
    }

    public void setAllFieldAndSubmit(String fullName, String email, String curAddr, String permAddr) {
        setFullName(fullName);
        setEmail(email);
        setCurrentAddress(curAddr);
        setPermanentAddress(permAddr);
        clickSubmit();
    }

    public void clickSubmit() {

        click(By.xpath(SUBMIT));
    }


    public String getOutputName() {
        String locator = String.format(OUTPUT_XPATH, "name");
        return getText(By.xpath(locator));
    }

    public String getOutputEmail() {
        String locator = String.format(OUTPUT_XPATH, "email");
        return getText(By.xpath(locator));
    }

    public String getOutputCurAddr() {
        String locator = String.format(OUTPUT_XPATH, "currentAddress");
        return getText(By.xpath(locator));
    }

    public String getOutputPermAddr() {
        String locator = String.format(OUTPUT_XPATH, "permanentAddress");
        return getText(By.xpath(locator));
    }


}
