package tests.googleTest.mailInGoogleChrome;

import googleChrome.base.BrowserParameters;
import googleChrome.pageObject.*;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;


public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        String email = "testavtomatone@mail.ru";
        String password = "toHOO1rU-ko4";
        String themeLetter = "Письмо от автотеста2";
        String letterText = "Письмо отправлено автотестом. Пусть сам и отвечает2";
        String testSign = "Новая подпись2";

        BrowserParameters searchBrowserWindow = new BrowserParameters(getDriver());
        RequestLoginToMail stepsLogin = new RequestLoginToMail(getDriver());
        RequestWriteLetter stepsWrite = new RequestWriteLetter(getDriver());
        RequestCheckLetter stepsCheck = new RequestCheckLetter(getDriver());
        RequestModifiSign stepsModSign = new RequestModifiSign(getDriver());
        RequestDeleteLetter stepsDelete = new RequestDeleteLetter(getDriver());


        /**
         * Шаги входа в почту.
         */

        stepsLogin.goToURL("https://mail.ru/");    //Вводим адрес в адресную строку
        stepsLogin.setTextToLogin(email);   //Вводим почту
        stepsLogin.setButtonEnterPassword();   //Нажимаем кнопку "Ввести пароль"
        stepsLogin.setTextToPassword(password);  //Вводим пароль от почты
        stepsLogin.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

        /**
         * Шаги отправки письма.
         */

        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsWrite.checkWindow("Отправить");    //Проверяем что находимся на форме создания
        stepsWrite.setTextToWhom(email); //Вводим почту в поле "Кому"
        stepsWrite.setTextSubjectLetter(themeLetter); //Вводим тему письма
        stepsWrite.setTextContentLetter(letterText);  //Вводим текст письма
        stepsWrite.setButtonSendMail(); //Отправляем письмо

        /**
         * Шаги проверки письма.
         */

         //Проверка наличия МО "Письмо отправлено"
        if (stepsCheck.checkModalWindow("Письмо отправлено")){
           stepsCheck.setButtonCloseModalWindow();
        }
        stepsCheck.setButtonGoToIn();   //Переход на страницу "Входящие"
        stepsCheck.resultFindLetter(themeLetter); //Поиск отправленного письма
        for (int i = 0; i < 2; i++) {
            stepsCheck.setButtonListLetter(themeLetter);   //Раскрытие списка писем и нажатие на последнее письмо с заданным заголовком
        }
        stepsCheck.checkThemeLetter(themeLetter); //Проверка темы письма
        stepsCheck.checkLetterText(letterText);   //Проверка содержимого письма

        /**
         * Шаги изменения подписи.
         */

        stepsModSign.setFindSetting();  //Раскрытие элекмента с настройками
        stepsModSign.setButtonAllSetting(); //Переход в общие настройки
        searchBrowserWindow.searchWindow(); //Проверка активного окна
        stepsModSign.setButtonSettingLetter();  //Нажатие на настройки писем
        stepsModSign.setButtonEditSign();   //Открыти МО настроек подписи
        stepsModSign.setEditTextSign(testSign);   //Изменение подписи
        stepsModSign.setButtonSaveSign();   //Сохранение изменений подписи
        stepsModSign.setButtonBack();   //Переход в почтовый ящик

        /**
         * Шаги проверки измененной подписи.
         */

        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsCheck.checkModalWindow("Отправить");   //Проверка что находимся на форме создания
        stepsModSign.checkNewSign(testSign);    //Проверяем подпись

        /**
         * Повторная отправка письма.
         */

         stepsWrite.setTextToWhom(email); //Вводим почту в поле "Кому"
         stepsWrite.setTextSubjectLetter(themeLetter); //Вводим тему письма
         stepsWrite.setTextContentLetter(letterText);  //Вводим текст письма
         stepsWrite.setButtonSendMail(); //Отправляем письмо

        /**
         * Шаги проверки письма.
         */

        //Проверка наличия МО "Письмо отправлено"
        if (stepsCheck.checkModalWindow("Письмо отправлено")) {
            stepsCheck.setButtonCloseModalWindow();
        }
        stepsCheck.setButtonGoToIn();   //Переход на страницу "Входящие"
        stepsCheck.resultFindLetter(themeLetter); //Поиск отправленного письма
         for (int j = 0; j < 2; j++) {
            stepsCheck.setButtonListLetter(themeLetter);   //Раскрытие списка писем и нажатие на последнее письмо с заданным заголовком
         }
        stepsCheck.checkThemeLetter(themeLetter); //Проверка темы письма
        stepsCheck.checkLetterText(letterText);   //Проверка содержимого письма
        stepsModSign.checkNewSign(testSign); //Проверка новой подписи

        /**
         * Шаги удаления письма.
         */

        stepsDelete.setButtonBack();   //Возвращаемся на старницу "Входящие"
        //stepsCheck.setButtonListLetter(themeLetter);    //Раскрытие сприска писем
        while (stepsDelete.checkLetter(themeLetter)) {  //Проверка наличия письма с неустановленным чекбоксом
                stepsDelete.activeCheckBox(themeLetter);    //Навдение на письмо
                stepsDelete.buttonCheckLetter(themeLetter); //Нажатие на чекбокс
        }
        stepsDelete.setButtonDelete();  //удаление выбранных писем
    }
}
