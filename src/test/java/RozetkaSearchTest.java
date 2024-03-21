import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RozetkaSearchTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        CategoryPage categoryPage = new CategoryPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage().enterTextInSearchBar("");
        homePage.enterTextInSearchBar("Кавомашина");
        homePage.waitSeconds(2);
        homePage.selectFirstSuggestion();
        homePage.enterTextInSearchBar("KRUPS");
        categoryPage.clickSearchButton();
        categoryPage.checkSearchResultTitle();
        driver.quit();
    }
}
