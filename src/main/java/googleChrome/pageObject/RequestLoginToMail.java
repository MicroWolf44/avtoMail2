package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestLoginToMail extends BrowserParameters {


    public RequestLoginToMail(WebDriver driver) {
        super(driver);
    }

    /**
     * xpath поиск поля для ввода логина.
     */
    @FindBy(xpath = ".//input[@name='login']")
    WebElement textToLogin;

    public void setTextToLogin(final String text){

        sendText(textToLogin, text);
    }

    /**
     * xpath поиска кнопки "Ввести пароль" и нажатие.
     */
    @FindBy(xpath = ".//button[contains(.,'Ввести пароль')]")
    WebElement buttonEnterPassword;

    public void setButtonEnterPassword(){

        click(buttonEnterPassword);
    }

    /**
     * xpath поиск поля для ввода пароля.
     */
    @FindBy(xpath = ".//input[@name='password']")
    WebElement textToPassword;

    public void setTextToPassword(final String text){

        sendText(textToPassword, text);
    }

    /**
     * xpath поиска кнопки "Войти" и нажатие.
     */
    @FindBy(xpath = ".//div[@id='mailbox']//button[contains(.,'Войти')]")
    WebElement buttonLoginToMail;

    public void setButtonLoginToMail(){

        click(buttonLoginToMail);
    }

}
