package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RequestCheckLetter extends BrowserParameters {


    public RequestCheckLetter(WebDriver driver) {
        super(driver);
    }

    /**
     * xpath проверка отображения окна "Письмо отправлено".
     */

    public boolean checkModalWindow(final String checkMW) {

        String xpath = ".//class[text()='"+checkMW+"']";
        //assert result;
        boolean result = waitOfElement(xpath);
        return result;

    }

    /**
     * xpath закрытия окна "Письмо отправлено".
     */

    @FindBy(xpath = ".//a[text()='Письмо отправлено']/../..//span[@title='Закрыть']")
    WebElement buttonCloseModalWindow;

    public void setButtonCloseModalWindow(){

        click(buttonCloseModalWindow);
    }

    /**
     * xpath перехода на страницу "Входящие".
     */

    @FindBy(xpath = ".//div[text()='Входящие']")
    WebElement buttonGoToIn;

    public void setButtonGoToIn(){

        click(buttonGoToIn);
    }

    /**
     * xpath проверки наличия письма.
     */

    public void resultFindLetter(final String resultFL){

        String xpath = ".//descendant::div[@id='app-canvas']//span[text()='"+resultFL+"')]";
        boolean result = waitOfElement(xpath);
        assert result;

    }

    /**
     * xpath открытие списка писем.
     */

    public void setButtonListLetter(final String themeLetter){

        String thLetter = "(.//descendant::div[@id='app-canvas']//span[text()='"+themeLetter+"'])[1]";
        WebElement buttonListLetter = getDriver().findElement(By.xpath(thLetter));
        click(buttonListLetter);
    }

    /**
     * xpath проверки темы письма.
     */

    public void checkThemeLetter(final String resultTL){

        String xpath = ".//h2[text()='"+resultTL+"')]";
        boolean result = waitOfElement(xpath);
        assert result;

    }

    /**
     * xpath проверки содержимого письма.
     */

    public void checkLetterText(final String resultTL){

        String xpath = ".//div[text()='"+resultTL+"')]";
        boolean result = waitOfElement(xpath);
        assert result;

    }

}
