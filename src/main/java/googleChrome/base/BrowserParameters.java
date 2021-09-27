package googleChrome.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserParameters {

    private WebDriver driver;
    private int timeOut = 60;

    public BrowserParameters(final WebDriver driver){

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver(){

        return driver;
    }

    protected boolean waitOfElement(final WebElement element){

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    protected boolean waitOfElement(final String xpath){

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);

        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Переключение на новое окно.
     */

    public void searchWindow(){

        String newWindow = driver.getWindowHandle();
        String nextWindow = null;
        Set<String> listWindow = driver.getWindowHandles();

        for (String window: listWindow) {
            if (!window.equals(newWindow)){
                nextWindow = window;
                break;
            }
        };

        driver.switchTo().window(nextWindow);
    }

    /**
     * Инициирование нажатия на кнопку.
     */
    public void click(final  WebElement element){

        waitOfElement(element);
        element.click();
    }

    /**
     * Инициирование ввода текста в поле.
     */
    public  void  sendText(final WebElement element, final  String text){

        waitOfElement(element);
        element.sendKeys(text);
    }

    /**
     * Инициирование ввода адреса в адресную строку и максимизация окна.
     */
    public void goToURL(final String url){

        getDriver().get(url);
        //getDriver().manage().window().maximize(); //Развернуть во весь экран
    }

}
