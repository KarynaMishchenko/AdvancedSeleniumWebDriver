import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RozetkaNavigationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        homePage homePage = new homePage(driver);
        categoryPage categoryPage = new categoryPage(driver);

        homePage.openHomePage();
        homePage.moveToFooter();
        homePage.clickOnFooterInsta();
        homePage.waitSeconds(10);
        homePage.switchToTab();
        homePage.selectCategory();
        categoryPage.checkCategoryTitle("Побутова хімія");
        categoryPage.scrollDown();
        driver.quit();
    }
}
