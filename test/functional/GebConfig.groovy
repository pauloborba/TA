import org.openqa.selenium.chrome.ChromeDriver

// Path do chromedriver
String chromeDriverPath = "chromedriver\\chromedriver.exe"

driver = {
    File file = new File(chromeDriverPath);
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

baseUrl = "http://localhost:8080/"