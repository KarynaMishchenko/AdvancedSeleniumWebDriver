import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class dragAndDropPage {
    private WebDriver driver;

    public dragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openDragAndDropPage() {
        driver.get("https://mzabriskie.github.io/react-draggable/example/");
    }

}
