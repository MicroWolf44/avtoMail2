package tests.googleTest.mailInGoogleChrome;

import MailGoogleChrome.PageObject.MailStart;
import org.junit.Test;
import tests.googleTest.GoogleBrowser;

public class MailRu extends GoogleBrowser {

    @Test
    public void mailTest(){

        MailStart testOne = new MailStart(getDriver());

        /**
         * Шаги выполнения теста.
         */
        testOne.gotoURL("https://mail.ru/");    //Вводим адрес в адресную строку
        testOne.setTextToLogin("testavtomatone@mail.ru");   //Вводим почту
        testOne.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        testOne.setTextToPassword("A1v2t3o4");  //Вводим пароль от почты
        testOne.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

    }

}
