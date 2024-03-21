import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropPage {
    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openDragAndDropPage() {
        driver.get("https://mzabriskie.github.io/react-draggable/example/");
    }
    public void waitSeconds (Integer time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public void dragAndDrop(){
        WebElement dragBox =  driver.findElement(By.xpath("//div[text()='I can be dragged anywhere']"));
        WebElement dropBox =  driver.findElement(By.xpath("//div[text()='I can only be dragged horizonally']"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(dragBox, dropBox).perform();

    }
}
