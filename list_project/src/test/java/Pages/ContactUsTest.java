package Pages;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class ContactUsTest extends BaseTests {
    @Test
    public void check_completeForm () throws ClassNotFoundException {
       // ElectronicsCategory categoryPage = ElectronicsCategory.click_el_category();
        ContactUsPage form = HomePage.clickContact();
        form.completeForm("elen@aca.am","ahaa");
        assertFalse(ContactUsPage.completeForm(null, null));
    }
    @Test
    public void chech_name(){
        ContactUsPage helpPage = HomePage.clickContact();
        assertEquals(helpPage.get_NavElementText(), "Contact Us");
    }
    @Test
    public void check_page_content(){
        ContactUsPage helpPage = HomePage.clickContact();
        assertTrue(helpPage.content_Exists());
    }



}
