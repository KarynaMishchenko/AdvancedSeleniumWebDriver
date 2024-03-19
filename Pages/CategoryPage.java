import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class categoryPage {
    private WebDriver driver;

    public categoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCategoryTitle(String categoryText){
        WebElement categoryTitle =  driver.findElement(By.xpath("//h1[@class='portal__heading ng-star-inserted']"));
        Assert.assertEquals(categoryText, categoryTitle.getText());
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000)");
    }
    public void clickSearchButton(){
        WebElement searchButton =  driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"));
        searchButton.click();
    }
    public void checkSearchResultTitle(){
        WebElement searchResultTitle =  driver.findElement(By.xpath("//h2[@class='search-heading ng-star-inserted']"));
        Assert.assertNotNull(searchResultTitle.getText());

    }
}
