import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

environments {
    chrome {
        def chromeDriver = new File('chromedrivers/macOS/chromedriver')
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

        driver = { new ChromeDriver() }
    }

    firefox {
        driver = { new FirefoxDriver() }
    }
}