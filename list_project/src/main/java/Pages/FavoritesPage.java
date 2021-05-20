package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FavoritesPage {
    private WebDriver driver;
    //a list of pages we test
    public List<String> fav_items_links = Arrays.asList(new String[]
            {"https://www.list.am/item/15335757", "https://www.list.am/item/14734150"});

    private By isEmpty_Heart = By.cssSelector(".off");
    private By heart = By.id("sstar");
    private By selected_heart = By.cssSelector(".on");

    private By added_fav_hearth = By.cssSelector(".star");
    private By empty_fav_page = By.cssSelector("#contentr > div > div:nth-child(1)");
    private By fav_items_section = By.cssSelector("#contentr > div a");

    private String no_favs_text = "Դուք չունեք նախընտրած հայտարարություններ";

    public void addFavorite() {
        (new WebDriverWait(driver, 300)).until(ExpectedConditions.elementToBeClickable(driver.findElement(heart)));
        driver.findElement(heart).click();
    }

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean check_Empty_Heart() {
        return driver.findElement(isEmpty_Heart).findElements(isEmpty_Heart).size() > 0;
    }

    public void to_fav_item(int i) {
        driver.get(fav_items_links.get(i));
    }

    public List<String> get_favs() {
        List<String> item_links = new ArrayList<>();
        List<WebElement> users = driver.findElements(fav_items_section);

        (new WebDriverWait(driver, 300)).until(ExpectedConditions.visibilityOfAllElements(users));
        for (int i=0; i<users.size(); i++) {
            item_links.add(users.get(i).getAttribute("href"));
        }
        return item_links;
    }
    public void remove_favs() {
        List<WebElement> favs_hearts = driver.findElements(added_fav_hearth);

        for (int i=0; i<favs_hearts.size(); i++) {
            favs_hearts.get(i).click();
        }
    }

}


