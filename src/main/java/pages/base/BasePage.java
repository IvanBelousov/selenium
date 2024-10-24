package pages.base;

import constant.LocatorsType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static browser.Config.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By HEADER_XPATH = By.xpath("//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]");
    public static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";
    public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";
    public static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");
    public static final String BUTTON_XPATH = "//*[@type='button' and text()='%s']";

    public void openUrl(String url) {
        driver.get(url);
    }


    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void waitElementIsVisible(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    public void waitElementIsDisplay(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementDisplay(locator));
    }
    public void waitForElementsEnabled(By locator, int second){
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementEnabled(locator));
    }


    public void waitElementIsVisible(By locator) {
        waitElementIsVisible(locator, EXPLICIT_WAIT);
    }

    public void click(By locator) {
        findElement(locator).click();
    }
    public void doubleClick(By locator){
        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(locator)).perform();
    }
    public void contextClick(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(findElement(locator)).perform();
    }
    public void clear(By locator) {
        findElement(locator).clear();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public void sendKeysWithClear(By locator, String text){
        clear(locator);
        sendKeys(locator,text);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }


    public boolean isElementDisplay(By locator) {
        try {
            return findElement(locator).isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }
    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    public boolean isHeaderDisplayed() {
        return isElementDisplay(HEADER_XPATH);
    }


    public int getElementsCount(By locator) {
        return findElements(locator).size();
    }
    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).isSelected();
    }
    /**
     * Переводит чек-бокс в нужное состочние
     * @param checkBoxName - Название чек-бокса
     * @param state - нужное состочние, true если чек-бокс должен быть активным, false - если нет
     */
    public void setCheckBox(String checkBoxName, boolean state){
        //String locator = String.format(CHECK_BOX_XPATH, checkBoxName) + "/following-sibling::span[@class='rct-checkbox']";
        if (!getCheckBoxState(checkBoxName)==state){
            click(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
        }
    }
    public boolean getRadioButtonState(By locator){
        return findElement(locator).isSelected();
    }

    public void setRadioButton (By locator){
        click(locator);
    }

    public By locatorBuild(String textLocator, LocatorsType locatorsType) {
        By locator = null;
        switch (locatorsType) {
            case ID:
                locator = By.id(textLocator);
                break;
            case XPATH:
                locator = By.xpath(textLocator);
                break;
            case CSS:
                locator = By.cssSelector(textLocator);
                break;
            case NAME:
                locator = By.name(textLocator);
                break;
            case TAG_NAME:
                locator = By.tagName(textLocator);
                break;
            case CLASS_NAME:
                locator = By.className(textLocator);
            default:
                System.out.println("Некорректный вид селектора: " + locatorsType);
        }
        return locator;
    }
    public void failure() {
        throw new AssertionError();
    }
    public String getPageName(){
        return getText(NAME_PAGE);
    }
    public void buttonClick(String buttonName){
        click(By.xpath(String.format(BUTTON_XPATH,buttonName)));
    }

    public String getAttributeValue(By locator, String attribute){
        return findElement(locator).getCssValue(attribute);
    }

}
