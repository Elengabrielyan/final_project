package Pages;
import Base.BaseTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public class FavoritesTest extends BaseTests {

    @Test
    public void check_add_item() {
        FavoritesPage savedPage = ProfilePage.go_saved_items();
        savedPage.to_fav_item(0);
        Boolean isHeartEmptyInitial = savedPage.check_Empty_Heart();
        savedPage.addFavorite();
        Assert.assertNotEquals((savedPage.check_Empty_Heart()), isHeartEmptyInitial);
    }

    @Test
    public void check_added_saved() {
        FavoritesPage save_page = ProfilePage.go_saved_items();
        for(int i = 0; i < save_page.fav_items_links.size(); i++) {
            save_page.to_fav_item(i);
            save_page.addFavorite();
        }

        save_page = ProfilePage.go_saved_items();
        List<String> favs = save_page.get_favs();
        Collections.sort(favs);
        Collections.sort(save_page.fav_items_links);
        assertEquals(favs, save_page.fav_items_links);
    }
    @Test
    public void removed_func(){
        FavoritesPage save_page = ProfilePage.go_saved_items();
        for(int i = 0; i < save_page.fav_items_links.size(); i++) {
            save_page.remove_favs();
        }


    }

}
