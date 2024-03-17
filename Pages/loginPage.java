import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class loginPage {
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingEmailField(String email){
        WebElement emailField =  driver.findElement(By.id("auth_email"));
        emailField.sendKeys(email);
    }
    public void fillingPasswordField(String password){
        WebElement emailField =  driver.findElement(By.id("auth_pass"));
        emailField.sendKeys(password);
    }
    public void checkHidingPassword(){
        WebElement emailField =  driver.findElement(By.id("auth_pass"));
        Assert.assertEquals("password",emailField.getAttribute("type") );
    }
    public void clickOnLogIn(){
        WebElement login =  driver.findElement(By.cssSelector("button.button--large.button--green.auth-modal__submit.ng-star-inserted"));
        login.click();
    }
    public void checkRobotMessage(){
        WebElement robotMessage = driver.findElement(By.cssSelector(".error-message.error-message_color_red"));
        Assert.assertEquals("Необхідно підтвердити, що ви не робот", robotMessage.getText());
    }
}
