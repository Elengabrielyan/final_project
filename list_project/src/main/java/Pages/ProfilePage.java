package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private static WebDriver driver;

    private By save_button = By.cssSelector("#notification_infoaction__form_action0");
    private By the_profile = By.cssSelector("#tabmenu > div:nth-child(1) > a");
    private static By acc_information = By.cssSelector("#ma > div");
    private By logout = By.cssSelector("#main > div.page_info");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public static FavoritesPage go_saved_items() {
        WebElement options = driver.findElement(acc_information);
        ((JavascriptExecutor) driver).executeScript("var ele=arguments[0]; ele.style.display = 'block';", options);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#contentr > div a"))));
        driver.findElement(By.cssSelector("#contentr > div a")).click();
        return new FavoritesPage(driver);
    }

    public void waitForLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(logout)));
    }

    public void profile_click() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(the_profile)));
        driver.findElement(the_profile).click();
    }

    public void save_click() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(save_button)));
        driver.findElement(save_button).click();
    }

}