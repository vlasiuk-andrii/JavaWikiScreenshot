package pageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WikiPage {
    WebDriver driver;
    public WikiPage(WebDriver ldriver){
        this.driver = ldriver;
    }

    public  void getWikiPaga(String url){
        driver.get(url);
    }

    public void makeScreenshot() throws IOException {

        WebElement elem = driver.findElement(By.xpath("//div[@id='mp-itn']/div[@id='mp-itn-img']/div[@class='thumbinner mp-thumb']/a/img"));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = elem.getLocation();

        int eleWidth = elem.getSize().getWidth();
        int eleHeight = elem.getSize().getHeight();

        BufferedImage elemScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(elemScreenshot, "png", screenshot);

        FileUtils.copyFile(screenshot, new File("c:\\Users\\andrey.prudnyk\\IdeaProjects\\WikiScreenshot\\WikiScreenshot.png"));
    }

}
