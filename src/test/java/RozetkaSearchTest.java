import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RozetkaSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        categoryPage categoryPage = new categoryPage(driver);
        homePage homePage = new homePage(driver);

        homePage.openHomePage();
        homePage.enterTextInSearchBar("Кавомашина");
        homePage.waitSeconds(2);
        homePage.selectFirstSuggestion();
        homePage.enterTextInSearchBar("KRUPS");
        categoryPage.clickSearchButton();
        categoryPage.checkSearchResultTitle();
        driver.quit();
    }
}
