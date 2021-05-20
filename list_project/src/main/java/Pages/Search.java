package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends BasePage {
    private static WebDriver driver;
    private static By searchBox = By.xpath("//*[@id=\"idSearchBox\"]");
    private By enter = By.xpath("//*[@id=\"idSearchF\"]/button");

    protected Search(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public static Search click_search() {
        findElementBy(searchBox).click();
        System.out.println(findElementBy(searchBox).getClass());
        return null;
    }

    public static Search defSearchBox(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBox)));
        driver.findElement(searchBox).sendKeys(text);
        return null;
    }

    public void enter() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(enter)));
        driver.findElement(enter).click();
    }

}
