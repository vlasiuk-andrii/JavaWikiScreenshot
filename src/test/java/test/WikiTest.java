package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObject.WikiPage;

import java.io.IOException;

public class WikiTest {
    WebDriver driver;

    @BeforeTest
    public void shutUt(){
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void shutDown(){
        driver.close();
    }

    @Test
    public void wikiTest() throws IOException {
        WikiPage onWikiPage = new WikiPage(driver);
        onWikiPage.getWikiPaga("https://en.wikipedia.org/wiki/Main_Page");
        onWikiPage.makeScreenshot();
    }

}
