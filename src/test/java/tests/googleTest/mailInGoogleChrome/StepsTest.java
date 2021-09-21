package tests.googleTest.mailInGoogleChrome;

import googleChrome.pageObject.XpathRequest;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;

public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        XpathRequest testOne = new XpathRequest(getDriver());

        /**
         * Шаги выполнения теста.
         */

        testOne.goToURL("https://mail.ru/");    //Вводим адрес в адресную строку
        testOne.setTextToLogin("testavtomatone@mail.ru");   //Вводим почту
        testOne.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        testOne.setTextToPassword("A1v2t3o4");  //Вводим пароль от почты
        testOne.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

    }

}
