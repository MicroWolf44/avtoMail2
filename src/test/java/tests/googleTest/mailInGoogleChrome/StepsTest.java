package tests.googleTest.mailInGoogleChrome;

import googleChrome.pageObject.RequestLoginToMail;
import googleChrome.pageObject.RequestWriteLetter;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;

public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        RequestLoginToMail stepsLogin = new RequestLoginToMail(getDriver());
        RequestWriteLetter stepsWrite = new RequestWriteLetter(getDriver());

        /**
         * Шаги входа в почту.
         */

        stepsLogin.goToURL("https://mail.ru/");    //Вводим адрес в адресную строку
        stepsLogin.setTextToLogin("testavtomatone@mail.ru");   //Вводим почту
        stepsLogin.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        stepsLogin.setTextToPassword("A1v2t3o4");  //Вводим пароль от почты
        stepsLogin.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

        /**
         * Шаги отправки письма.
         */

        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsWrite.checkWindow("Отправить");    //Проверяем что находимся на форме создания
        stepsWrite.setTextToWhom("testavtomatone@mail.ru"); //Вводим почту в поле "Кому"
        stepsWrite.setTextSubjectLetter("Письмо от автотеста"); //Вводим тему письма

    }

}
