package tests.googleTest.mailInGoogleChrome;

import googleChrome.base.BrowserParameters;
import googleChrome.pageObject.*;
import org.junit.Test;
import tests.googleTest.GoogleBrowserWatcher;


public class StepsTest extends GoogleBrowserWatcher {

    @Test
    public void mailTest(){

        String email = "testavtomatone@mail.ru";
        String themeLetter = "Письмо от автотеста";
        String letterText = "Письмо отправлено автотестом. Пусть сам и отвечает";
        String testSign = "Новая подпись";

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
        stepsLogin.setTextToPassword("toHOO1rU-ko4");  //Вводим пароль от почты
        stepsLogin.setButtonLoginToMail(); //Нажимаем кнопку "Войти"

        /**
         * Шаги отправки письма.
         */
        /**
        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsWrite.checkWindow("Отправить");    //Проверяем что находимся на форме создания
        stepsWrite.setTextToWhom(email); //Вводим почту в поле "Кому"
        stepsWrite.setTextSubjectLetter(themeLetter); //Вводим тему письма
        stepsWrite.setTextContentLetter(letterText);  //Вводим текст письма
        stepsWrite.setButtonSendMail(); //Отправляем письмо
        */
        /**
         * Шаги проверки письма.
         */
        /**
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
        */
        /**
         * Шаги изменения подписи.
         */

        /**
        stepsModSign.setFindSetting();  //Раскрытие элекмента с настройками
        stepsModSign.setButtonAllSetting(); //Переход в общие настройки
        searchBrowserWindow.searchWindow(); //Проверка активного окна
        stepsModSign.setButtonSettingLetter();  //Нажатие на настройки писем
        stepsModSign.setButtonEditSign();   //Открыти МО настроек подписи
        stepsModSign.setEditTextSign("textSign");   //Изменение подписи
        stepsModSign.setButtonSaveSign();   //Сохранение изменений подписи
        stepsModSign.setButtonBack();   //Переход в почтовый ящик
        */

        /**
         * Шаги проверки измененной подписи.
         */
        /**
        stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
        stepsCheck.checkModalWindow("Отправить");   //Проверка что находимся на форме создания
        stepsModSign.checkNewSign(testSign);    //Проверяем подпись
        */
        /**
         * Повторная отправка письма.
         */
        /**
         stepsWrite.setButtonWriteLetter();  //Нажимаем кнопку "Написать письмо"
         stepsWrite.checkWindow("Отправить");    //Проверяем что находимся на форме создания
         stepsWrite.setTextToWhom(email); //Вводим почту в поле "Кому"
         stepsWrite.setTextSubjectLetter(themeLetter); //Вводим тему письма
         stepsWrite.setTextContentLetter(letterText);  //Вводим текст письма
         stepsWrite.setButtonSendMail(); //Отправляем письмо
         **
        /**
         * Шаги проверки письма.
         */
        //Проверка наличия МО "Письмо отправлено"
        /**
        if (stepsCheck.checkModalWindow("Письмо отправлено")) {
            stepsCheck.setButtonCloseModalWindow();
        }
        stepsCheck.setButtonGoToIn();   //Переход на страницу "Входящие"
        stepsCheck.resultFindLetter(themeLetter); //Поиск отправленного письма
         for (int i = 0; i < 2; i++) {
         stepsCheck.setButtonListLetter(themeLetter);   //Раскрытие списка писем и нажатие на последнее письмо с заданным заголовком
         }
        stepsCheck.checkThemeLetter(themeLetter); //Проверка темы письма
        stepsCheck.checkLetterText(letterText);   //Проверка содержимого письма
        stepsModSign.checkNewSign(testSign); //Проверка новой подписи

        */
        /**
         * Шаги удаления письма.
         */

        stepsCheck.setButtonGoToIn();
        stepsCheck.setButtonListLetter(themeLetter);
        //while (stepsDelete.setCheckShowMoreLetter()==true){
        //    stepsDelete.setButtonShowMoreLetter();
        //}

        int size = stepsDelete.sizeLetter(themeLetter);
        for (int i=2; i <= size; i++){
            stepsDelete.buttonCheckLetter(themeLetter, i);
        }
        //stepsDelete.setButtonDelete();
    }
}
