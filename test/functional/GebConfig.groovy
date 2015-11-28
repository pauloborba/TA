//import org.openqa.selenium.chrome.ChromeDriver
//
//driver = {
//    File file = new File("C:/Users/eduar/git/TA/chromedrivers/chromedriver.exe");
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
    // run as â€œgrails -Dgeb.env=chrome test-appâ€?
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

    // run as â€œgrails -Dgeb.env=firefox test-appâ€?
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
}