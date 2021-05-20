package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;
public class HomePage extends BasePage {
    public static final String BASE_URL = "https://www.list.am/en/";
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @FindBy(xpath = "//*[@id=\"idSearchBox\"]")
    WebElement search_bar;


    private By search_box = By.xpath("//*[@id=\"idSearchBox\"]");
    private By searchBox = By.xpath("//*[@id=\"idSearchBox\"]");
    public Search search_box () {

      findElementBy(search_box).click();
        return new Search(driver);
    }

    /*public static RegisteredUser clickSearch(){
        clickLink("Իմ էջը");
        return new RegisteredUser(driver);
    }*/

    private static void clickLink(String Text){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(Text))));
        driver.findElement(By.linkText(Text)).click();
    }

    protected void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(BASE_URL));
    }


    public void clickMyPage() {
        search_bar.click();
    }
    public void click_search() {
        findElementBy(searchBox).click();
        System.out.println(findElementBy(searchBox).getClass());
    }
    public ElectronicsCategory click_el_category(){
        WebElement search = driver.findElement(By.cssSelector("a[href $= \"y/11\"]"));
        search.click();
        search.sendKeys(Keys.RETURN);
        return new ElectronicsCategory(driver);
    }

    public static ContactUsPage clickContact(){
        clickLink("Contact Us");
        return new ContactUsPage(driver);
    }




}