package tests.googleTest.mailInGoogleChrome;

import googleChrome.pageObject.RequestCheckLetter;
import googleChrome.pageObject.RequestLoginToMail;
import googleChrome.pageObject.RequestModifiSign;
import googleChrome.pageObject.RequestWriteLetter;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;

import java.util.HashMap;
import java.util.Map;

public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        String themeLetter = "Письмо от автотеста";
        String letterText = "Письмо отправлено автотестом. Пусть сам и отвечает";

        RequestLoginToMail stepsLogin = new RequestLoginToMail(getDriver());
        RequestWriteLetter stepsWrite = new RequestWriteLetter(getDriver());
        RequestCheckLetter stepsCheck = new RequestCheckLetter(getDriver());
        RequestModifiSign stepsModSign = new RequestModifiSign(getDriver());

        /**
         * Шаги входа в почту.
         */

        stepsLogin.goToURL("https://mail.ru/");    //Вводим адрес в адресную строку
        stepsLogin.setTextToLogin("testavtomatone@mail.ru");   //Вводим почту
        stepsLogin.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        stepsLogin.setTextToPassword("toHOO1rU-ko4");  //Вводим пароль от почты
        stepsLogin.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

        /**
         * Шаги отправки письма.
         */

        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsWrite.checkWindow("Отправить");    //Проверяем что находимся на форме создания
        stepsWrite.setTextToWhom("testavtomatone@mail.ru"); //Вводим почту в поле "Кому"
        stepsWrite.setTextSubjectLetter(themeLetter); //Вводим тему письма
        stepsWrite.setTextContentLetter(letterText);  //Вводим текст письма
        stepsWrite.setButtonSendMail(); //Отправляем письмо

        /**
         * Шаги проверки письма.
         */
        //иф не работает если нет окна
        if (stepsCheck.checkModalWindow("Письмо отправлено")){
            stepsCheck.setButtonCloseModalWindow();
        }
        stepsCheck.setButtonGoToIn();   //Переход на страницу "Входящие"
        stepsCheck.resultFindLetter(themeLetter); //Поиск отправленного письма
        stepsCheck.setButtonListLetter();   //Раскрытие списка писем
        stepsCheck.setButtonListLetter();   //Нажатие на последнее письмо с заданным заголовком
        stepsCheck.checkThemeLetter(themeLetter); //Проверка темы письма
        stepsCheck.checkLetterText(letterText);   //Проверка содержимого письма

    }

}
