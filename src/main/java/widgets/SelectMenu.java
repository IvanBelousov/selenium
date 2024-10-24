package widgets;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SelectMenu extends BasePage {
    public SelectMenu(WebDriver driver) {
        super(driver);
    }
    public static final String URL_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    public void openSelectMenuPage(){
        openUrl(URL_SELECT_MENU_PAGE);
    }
}
