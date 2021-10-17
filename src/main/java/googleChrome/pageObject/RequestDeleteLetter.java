package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
        return waitOfElement(xpath);

    }

    /**
     * Подсчет количества писем
     */

    public boolean sizeLetter(final String themeLetter){

            //Number xpath = (Number) getDriver().findElement(By.xpath("count(.//descendant::div[@class='app-canvas']//span[text() = '"+themeLetter+"'])"));
        try {
            WebElement xpath = getDriver().findElement(By.xpath(".//descendant::div[@class='app-canvas']//span[text() = '"+themeLetter+"']"));
            JavascriptExecutor run = (JavascriptExecutor) getDriver();
            run.executeScript("arguments[1].click()", xpath);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Наведение на письмо, что бы отобразился чекбокс
     */

    public void activeCheckBox (final String themeLetter) {

        //(.//span[text() = 'Письмо от автотеста']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox']//ancestor::a[@tabindex='-1'])[2]
        String xpathTarget = "(.//span[text() = '"+themeLetter+"']//ancestor::a[@tabindex='-1']//div[@class='checkbox__box checkbox__box_disabled']//ancestor::a[@tabindex='-1'])[1]";

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

    public boolean checkLetter (final String themeLetter){
        String xpath = ".//span[text() = '"+themeLetter+"']//ancestor::a[@tabindex='-1']//div[@class='checkbox__box checkbox__box_disabled']";
        return waitOfElement(xpath);
    }

    public void buttonCheckLetter(final String themeLetter){
                        //(.//span[text() = 'Письмо от автотеста']//ancestor::div[@class = 'draggable']//input[@type = 'checkbox'])[2]
                        //.//descendant::div[@id='app-canvas']//span[text() = 'Письмо от автотеста']//ancestor::a[@tabindex='-1']//div[@class='checkbox__box checkbox__box_disabled']
        String xpath = "(.//span[text() = '"+themeLetter+"']//ancestor::a[@tabindex='-1']//div[@class='checkbox__box checkbox__box_disabled'])[1]";

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