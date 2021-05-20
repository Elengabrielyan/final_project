package Pages;
import Base.BaseTests;
import org.testng.annotations.Test;
//  //*[@id="menu"]/div/div[4]/a
import static org.testng.Assert.*;
//Filter by price
public class ElectronicsCategoryTest extends BaseTests {

    @Test
    public void checking_Sub_Nav(){
        ElectronicsCategory categoryPage = ElectronicsCategory.click_el_category();
        assertEquals(categoryPage.sub_name_get(), "Էլեկտրոնիկա");
    }

    @Test
    public void checking_Sidebar(){
        ElectronicsCategory categoryPage = ElectronicsCategory.click_el_category();
        assertTrue(categoryPage.sidebar());
    }

    @Test
    public void checking_Filter() {
        boolean el_category_page = ElectronicsCategory.sidebar();
        ElectronicsCategory.filter_option();
        assertTrue(!Pages.ElectronicsCategory.price_box_check());
    }
    @Test
    public void checking_priceFrom () {
        ElectronicsCategory categoryPage = ElectronicsCategory.click_el_category();
        categoryPage.set_price_sizeFrom("30000");
        categoryPage.set_price_sizeTo("180000");
        categoryPage.set_currency_selection(1);
        assertFalse(categoryPage.nothing_found());
    }

}