package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestCheckLetter extends BrowserParameters {


    public RequestCheckLetter(WebDriver driver) {
        super(driver);
    }

    /**
     * xpath проверка отображения страницы.
     */

    public boolean checkModalWindow(final String checkMW) {

        String xpath = ".//class[text()='"+checkMW+"']";
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

        String xpath = ".//span[text()='"+resultFL+"']";
        boolean result = waitOfElement(xpath);
        assert result;
    }

    /**
     * xpath открытие списка писем.
     */

    @FindBy(xpath = "")
    WebElement buttonListLetter;

    public void setButtonListLetter(){
        click(buttonListLetter);
    }

}
