package googleChrome.pageObject;

import googleChrome.base.BrowserParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestModifiSign extends BrowserParameters {

    public RequestModifiSign(WebDriver driver) {
        super(driver);
    }

    /**
     * xpath открытия настроек.
     */

    @FindBy(xpath = ".//span[@title='Настройки']")
    WebElement findSetting;

    public void setFindSetting(){

        click(findSetting);
    }

    /**
     * xpath переход в общие настройки.
     */

    @FindBy(xpath = ".//span[text()='Все настройки']")
    WebElement buttonAllSetting;

    public void setButtonAllSetting(){

        click(buttonAllSetting);
    }

    /**
     * xpath открытие настроек писем.
     */

    @FindBy(xpath = ".//h4[text()='Работа с письмами']")
    WebElement buttonSettingLetter;

    public void setButtonSettingLetter(){

        click(buttonSettingLetter);
    }

    /**
     * xpath изменения подписи писем.
     */

    @FindBy(xpath = ".//h2[text()='Имя отправителя и подпись']//..//button[@data-test-id='edit']")
    WebElement buttonEditSign;

    public void setButtonEditSign(){

        click(buttonEditSign);
    }

    @FindBy(xpath = ".//small[text()='Подпись']/..//div[@role='textbox']")
    WebElement editTextSign;

    public void setEditTextSign(final String text){

        sendText(editTextSign, text);
    }

}
