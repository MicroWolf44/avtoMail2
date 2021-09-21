package tests.googleTest.mailInGoogleChrome;

import googleChrome.pageObject.RequestLoginToMail;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;

public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        RequestLoginToMail stepsLogin = new RequestLoginToMail(getDriver());

        /**
         * Шаги выполнения теста.
         */

        stepsLogin.goToURL("https://mail.ru/");    //Вводим адрес в адресную строку
        stepsLogin.setTextToLogin("testavtomatone@mail.ru");   //Вводим почту
        stepsLogin.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        stepsLogin.setTextToPassword("A1v2t3o4");  //Вводим пароль от почты
        stepsLogin.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

    }

}
