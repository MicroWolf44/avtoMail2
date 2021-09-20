package tests.googleTest;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleBrowser extends Base {

    @Rule
    public TestWatcher watcher;
    {
        watcher = new TestWatcher() {

            @Override
            protected void starting(Description description) {

                ChromeOptions chromeOptions = new ChromeOptions();
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                URL urlHab = null;

                try {
                    urlHab = new URL(googleUrl + "/wd/hub");
                }
                catch (MalformedURLException e){
                    e.printStackTrace();
                }
                driver =  new RemoteWebDriver(urlHab, desiredCapabilities);

            }

            @Override
            protected void succeeded(Description description) {
            }

            @Override
            protected void failed(Throwable e, Description description) {
            }

            @Override
            protected void finished(Description description) {

                driver.quit();
                if (driver != null){
                    driver.quit();
                }

            }
        };
    }

}
