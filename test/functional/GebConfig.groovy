import org.openqa.selenium.chrome.ChromeDriver

// Escreve aqui o path do chromedriver
String chromeDriverPath = "C:/SDK/Chromedriver/chromedriver.exe"

driver = {
    File file = new File(chromeDriverPath);
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

baseUrl = "http://localhost:8080/"
