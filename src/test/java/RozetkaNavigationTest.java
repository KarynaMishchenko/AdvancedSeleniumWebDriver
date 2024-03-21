import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RozetkaNavigationTest {
   /* public enum Driver{
        CHROME, EDGE;
    }
    public static Driver driverType;
    public static WebDriver driver = null;

    public static void setDriverType(Driver driverType) {
        RozetkaNavigationTest.driverType = driverType;
    }
*/
   public static WebDriver driver=null;
        @Parameters({"browser","port"})
        @BeforeClass
        public void initialize(String browser, String port) throws MalformedURLException{
                DesiredCapabilities capability= new DesiredCapabilities();
                capability.setBrowserName(browser);
                capability.setPlatform(Platform.WIN11);
                driver= new RemoteWebDriver(new URL("http://192.168.1.69:4444"), capability);
        }
    @Test
    public void RozetkaNavigationTest() {

        /*DesiredCapabilities caps = new DesiredCapabilities();
         caps.setPlatform(Platform.WIN11);
        if (driver == null) {
            switch (driverType) {
                case EDGE:
                    caps.setBrowserName("MicrosoftEdge");
                    break;
                case CHROME:
                    caps.setBrowserName("chrome");
                    break;
            }*/

            HomePage homePage = new HomePage(driver);
            CategoryPage categoryPage = new CategoryPage(driver);

            homePage.openHomePage();
            homePage.moveToFooter();
            homePage.clickOnFooterInsta();
            homePage.waitSeconds(10);
            homePage.switchToTab();
            homePage.selectCategory();
            categoryPage.checkCategoryTitle("Побутова хімія");
            categoryPage.scrollDown();
            categoryPage.highlightElement();
            categoryPage.refreshThePage();

            DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
            dragAndDropPage.openDragAndDropPage();
            dragAndDropPage.waitSeconds(4);
            dragAndDropPage.dragAndDrop();
            driver.quit();
        }
}
