package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestWriteLetter extends BrowserParameters {

    public RequestWriteLetter(WebDriver driver) {
        super(driver);
    }

    /**
     * xpath поиска кнопки "Написать письмо".
     */

    @FindBy(xpath = ".//span[text()='Написать письмо']")
    WebElement buttonWriteLetter;

    public void setButtonWriteLetter(){

        click(buttonWriteLetter);
    }

    /**
     * xpath проверки открывшегося окна.
     */

    public void checkWindow(final String checkWin){

        String xpath = ".//span[text()='"+checkWin+"']";
        boolean result = waitOfElementNoVisibility(xpath);
        assert result;
    }

    /**
     * xpath ввода адреса отправки.
     */

    @FindBy(xpath = ".//div[@data-type='to']//input[@type='text']")
    WebElement textToWhom;

    public void setTextToWhom(final String text){

        sendText(textToWhom, text);
    }

    /**
     * xpath ввода темы письма.
     */

    @FindBy(xpath = ".//div[text()='Тема']/../../..//input[@type='text']")
    WebElement textSubjectLetter;

    public void setTextSubjectLetter(final String text){

        sendText(textSubjectLetter, text);
    }

    /**
     * xpath Содержимое письма.
     */

    @FindBy(xpath = ".//div[@role='textbox']/div")
    WebElement textContentLetter;

    public void setTextContentLetter(final String text){

        sendText(textContentLetter, text);
    }

    /**
     * xpath нажатия кнопки "Отправить".
     */

    @FindBy(xpath = ".//span[text()='Отправить']")
    WebElement buttonSendMail;

    public void setButtonSendMail(){

        click(buttonSendMail);
    }
}
