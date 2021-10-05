package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

        ArrayList<WebElement> xpath = (ArrayList<WebElement>) getDriver().findElements(By.xpath(".//descendant::div[@class='app-canvas']//span[text() = '"+themeLetter+"']"));
        int size = xpath.size();
        return size;
    }

    public void buttonCheckLetter(final String themeLetter, int size){
                        //(.//span[text() = 'Письмо от автотеста']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox'])[2]
        String xpath = "(.//span[text() = '"+themeLetter+"']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox'])["+size+"]";
        try {
            WebElement useCheck = getDriver().findElement(By.xpath(xpath));
            click(useCheck);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = ".//descendant::div[@id = 'app-canvas']//span[text() = 'Удалить']")
    WebElement buttonDelete;

    public void setButtonDelete(){

        click(buttonDelete);
    }
}