//import org.openqa.selenium.chrome.ChromeDriver
//
//driver = {
//    File file = new File("/home/ess/TA2/chromedrivers/chromedriverlinux64");
//    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()  );
//    new ChromeDriver();
//}

//baseUrl = "http://localhost:8070/"

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

driver = {
//def driver = new HtmlUnitDriver()
//driver.javascriptEnabled = true
//driver
    def driver = new FirefoxDriver()
    driver
}

environments {
    // run as “grails -Dgeb.env=chrome test-app”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

    // run as “grails -Dgeb.env=firefox test-app”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
}