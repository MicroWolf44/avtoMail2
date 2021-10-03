package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestDeleteLetter extends BrowserParameters {

    public RequestDeleteLetter(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class = 'draggable']//a[text() = 'Загрузить ещё']")
    WebElement buttonShowMoreLetter;

    public void setButtonShowMoreLetter(){

        click(buttonShowMoreLetter);
    }

    public boolean setCheckShowMoreLetter(){

        String xpath = ".//div[@class = 'draggable']//a[text() = 'Загрузить ещё']";
        if (waitOfElement(xpath)) return true;
        else return false;

    }

    public int sizeLetter(final String themeLetter){

        String xpath = "(.//descendant::div[@class='app-canvas']//span[text() = '"+themeLetter+"']";
        try {
            int size = getDriver().findElements(By.xpath(xpath)).size();
            return size;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void buttonCheckLetter(final String themeLetter, int size){

        String xpath = "(.//span[text() = '"+themeLetter+"']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox'])["+size+"]";
        try {
            WebElement useCheck = getDriver().findElement(By.xpath(xpath));
            click(useCheck);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}