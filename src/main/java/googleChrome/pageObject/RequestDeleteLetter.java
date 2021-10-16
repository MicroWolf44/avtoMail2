package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDeleteLetter extends BrowserParameters {

    public RequestDeleteLetter(WebDriver driver) {
        super(driver);
    }

    /**
     * Нажатие на кнопку "Загрузить еще"
     */

    @FindBy(xpath = ".//div[@class = 'draggable']//a[text() = 'Загрузить ещё']")
    WebElement buttonShowMoreLetter;

    public void setButtonShowMoreLetter(){

        click(buttonShowMoreLetter);
    }

    /**
     * Проверка наличия кнопки "Загрузить еще"
     */
    public boolean setCheckShowMoreLetter(){

        String xpath = ".//div[@class = 'draggable']//a[text() = 'Загрузить ещё']";
        if (waitOfElement(xpath)) return true;
        else return false;

    }

    /**
     * Подсчет количества писем
     */

    public int sizeLetter(final String themeLetter){

        ArrayList<WebElement> xpath = (ArrayList<WebElement>) getDriver().findElements(By.xpath(".//descendant::div[@class='app-canvas']//span[text() = '"+themeLetter+"']"));
        int size = xpath.size();
        return size;
    }

    /**
     * Наведение на письмо, что бы отобразился чекбокс
     */

    public void activeCheckBox (final String themeLetter, int size) {

        //(.//span[text() = 'Письмо от автотеста']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox']//ancestor::a[@tabindex='-1'])[2]
        String xpathTarget = "(.//span[text() = '" + themeLetter + "']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox']//ancestor::a[@tabindex='-1'])[" + size + "]";

        try {
            WebElement actionLetter = getDriver().findElement(By.xpath(xpathTarget));
            Actions actions = new Actions(getDriver());
            actions.moveToElement(actionLetter).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Выбор чекбокса письма
     */

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

    /**
     * Нажатие на кнопку "Удалить"
     */

    @FindBy(xpath = ".//descendant::div[@id = 'app-canvas']//span[text() = 'Удалить']")
    WebElement buttonDelete;

    public void setButtonDelete(){

        click(buttonDelete);
    }
}