package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.constant.Constable;

import static org.testng.AssertJUnit.assertTrue;

public class ElectronicsCategory extends BasePage {
    private static WebDriver driver;

    private static By price_size_from = By.id("idprice1");
    private static By price_size_to = By.id("idprice2");
    private static By listLocator_curr = By.id("crc");
    private static By sidebar = By.xpath("//*[@id=\"ff\"]");
    private static By price_box = By.xpath("//*[@id=\"ff\"]/div[3]");
    private static By filter_option = By.xpath("//*[@id=\"ff\"]/div[1]/div[1]/div[2]/label");
    private static By the_sub_name = By.xpath("//*[@id=\"menu\"]/div/div[4]/a");
    private static By nothing_found = By.className("notfound");
    public ElectronicsCategory(WebDriver driver) {
        this.driver = driver;
    }

    public static ElectronicsCategory click_el_category(){
        WebElement search = driver.findElement(By.cssSelector("a[href $= \"y/11\"]"));
        search.click();
        search.sendKeys(Keys.RETURN);
        return new ElectronicsCategory(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public static void filter_option() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(filter_option)));
        driver.findElement(filter_option).click();
    }

    public static boolean price_box_check() {
       return !driver.findElements(price_box).isEmpty();
    }

    public static boolean sidebar() {
        return !driver.findElements(sidebar).isEmpty();
    }

    public Constable sub_name_get(){
        return driver.findElement(the_sub_name).getText();

    }
    public void set_price_sizeFrom (String price) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(price_size_from)));
        price_size_to.findElement((SearchContext) price_size_from).click();
        price_size_to.findElement((SearchContext) price_size_from).clear();
        price_size_to.findElement((SearchContext) price_size_from).sendKeys(price);

    }


    public void set_price_sizeTo (String price) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(price_size_to)));
        price_size_to.findElement((SearchContext) listLocator_curr).click();
        price_size_to.findElement((SearchContext) listLocator_curr).clear();
        price_size_to.findElement((SearchContext) listLocator_curr).sendKeys(price);
    }


    public void set_currency_selection (int index) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(listLocator_curr)));
        Select currency = new Select((WebElement) listLocator_curr);
        currency.selectByIndex(index);

    }
    public Boolean nothing_found() {
        return nothing_found.findElement((SearchContext) By.className("notfound")).isDisplayed();
    }

}