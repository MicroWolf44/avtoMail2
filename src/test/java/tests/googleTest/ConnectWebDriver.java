package tests.googleTest;

import org.openqa.selenium.WebDriver;

public class ConnectWebDriver {

    /**
     * Объявление подключения драйвера для работы с браузером.
     */
    protected String googleUrl = "http://localhost:4445";
    public WebDriver driver;

    public WebDriver getDriver(){

        return driver;
    }

    public void setDriver(WebDriver driver){

        this.driver = driver;
    }

}
