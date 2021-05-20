package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected static WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage() {
    }

    protected static WebElement findElementBy(By by){
        if(by == null){
            throw new IllegalArgumentException("'By' cannot be null!");
        }
        return driver.findElement(by);
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;
}