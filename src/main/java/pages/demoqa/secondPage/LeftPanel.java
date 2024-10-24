package pages.demoqa.secondPage;

import constant.CategoryCards;
import constant.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.elements.CheckBoxPage;
import pages.elements.TextBoxPage;

import static browser.Config.EXPLICIT_WAIT;

public class LeftPanel extends BasePage {
    public LeftPanel(WebDriver driver) {
        super(driver);
    }

    public static final String LEFT_PANEL_BLOCK_XPATH = "//div[@class='left-pannel']//div[@class='element-group'][descendant::div[text()='%s']]";
    public static final String OPEN_BLOCK_SVG_XPATH = LEFT_PANEL_BLOCK_XPATH + "/descendant::div[@class='icon']//*[name()='path' and @d='M3 19h18v2H3v-2zM13 5.828V17h-2V5.828L4.929 11.9l-1.414-1.414L12 2l8.485 8.485-1.414 1.414L13 5.83z']";
    public static final String LIST_ON_BLOCK_XPATH = LEFT_PANEL_BLOCK_XPATH + "/div[contains(@class,'element-list collapse')]";
    public static final String ITEM_XPATH = LEFT_PANEL_BLOCK_XPATH + "//li[span[text()='%s']]";

    public boolean isLeftPanelDisplayed(){
        boolean conditions = true;
        for (CategoryCards cards: CategoryCards.values()){
            if (!isElementDisplay(By.xpath(String.format(LEFT_PANEL_BLOCK_XPATH,cards.getName())))){
                conditions =false;
                break;
            }
        }
        return conditions;
    }

    public boolean isBlockOpen(CategoryCards blockName){
        return isElementDisplay(By.xpath(String.format(LIST_ON_BLOCK_XPATH,blockName.getName())));
    }

    public void waitForBlockOpen(CategoryCards blockName){
        waitElementIsDisplay(By.xpath(String.format(LIST_ON_BLOCK_XPATH,blockName.getName())),EXPLICIT_WAIT);
    }

    public void clickMenuItem(CategoryCards blockName, Item item){
        if (!isBlockOpen(blockName)){
            click(By.xpath(String.format(LEFT_PANEL_BLOCK_XPATH,blockName.getName())));
            waitForBlockOpen(blockName);
        }
        click(By.xpath(String.format(ITEM_XPATH,blockName.getName(),item.getName())));
    }

    public TextBoxPage openTextBoxPage(){
        clickMenuItem(CategoryCards.ELEMENTS,Item.TEXT_BOX);
        return new TextBoxPage(driver);
    }
    public CheckBoxPage openCheckBoxPage(){
        clickMenuItem(CategoryCards.ELEMENTS,Item.CHECK_BOX);
        return new CheckBoxPage(driver);
    }


}
