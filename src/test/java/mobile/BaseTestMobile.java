package mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class BaseTestMobile {

    @BeforeAll
    public static void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "375x812";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.1 (KHTML, like Gecko) Mobile/15E148");

        Configuration.browserCapabilities = options;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\",\"--headless\"");

    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

}