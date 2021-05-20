package Pages;
import Base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import static org.testng.Assert.*;
public class SearchTest extends BaseTests {

    private Object text;

    @Test
    public void test_searchbox() throws InterruptedException {
      
        Search search_field = Search.click_search();
        Thread.sleep(8000);
        search_field.defSearchBox("aaa");
        Thread.sleep(56000);
        search_field.enter();
        Thread.sleep(8000);
        System.out.println("Assert equals method validation");

        String url = driver.getCurrentUrl();
        Assert.assertNotEquals(url, "https://www.list.am/en/" );
    }



}