import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginNegativeTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
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
