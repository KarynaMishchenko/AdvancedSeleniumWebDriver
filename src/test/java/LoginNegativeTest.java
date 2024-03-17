import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginNegativeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        homePage homePage = new homePage(driver);
        loginPage loginPage = new loginPage(driver);
        homePage.openHomePage();
        homePage.clickOnUserIcon();
        homePage.waitSeconds(2);
        loginPage.fillingEmailField("mishchenko.karina@gmail.com");
        loginPage.fillingPasswordField("qwerty123456");
        loginPage.checkHidingPassword();
        loginPage.clickOnLogIn();
        loginPage.checkRobotMessage();
        driver.quit();
    }
}
