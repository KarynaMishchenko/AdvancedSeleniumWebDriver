import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openHomePage() {
        driver.get("https://rozetka.com.ua/ua/");
        return this;
    }
    public void enterTextInSearchBar(String searchText){
        WebElement textBox = driver.findElement(By.name("search"));
        textBox.sendKeys(searchText);
    }

    public void selectFirstSuggestion(){
        WebElement suggestion =  driver.findElement(By.xpath("(//li[@class='search-suggest__item ng-star-inserted'])[1]"));
        suggestion.click();
    }
    public void waitSeconds (Integer time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public void moveToFooter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='socials__link socials__link--instagram']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(footer).perform();
    }
    public void clickOnFooterInsta(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='socials__link socials__link--instagram']")));
        footer.click();
    }
    public void switchToTab(){
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                // Close the current tab or window
                driver.close();
                // Switch back to the previous tab or window
                driver.switchTo().window(currentHandle);
                break;
            }
        }
    }
    public void selectCategory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement firstCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='menu-categories__link'])[16]")));
        firstCategory.click();
    }

    public void clickOnUserIcon(){
        WebElement userIcon =  driver.findElement(By.cssSelector("use[href='#icon-user-simple']"));
        userIcon.click();
    }

}
