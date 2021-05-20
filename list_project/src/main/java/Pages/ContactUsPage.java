package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class ContactUsPage {
    private static WebDriver driver;

    private static By emailAddressField = By.id("_idyour_email");
    private static By yourMessageField = By.id("_idyour_message");
    private static By contact_page = By.xpath("//*[@id=\"pfooter\"]/div/div[3]/a[2]");



     public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }


    public static boolean completeForm(String email, String message) throws ClassNotFoundException {
        type(email, emailAddressField);
        type(message, yourMessageField);
        // click(saveButton);
        return false;
    }
    public String get_NavElementText() {
        return driver.findElement(contact_page).getText();
    }
    public boolean content_Exists () {
        return !driver.findElements(contact_page).isEmpty();
    }


}
