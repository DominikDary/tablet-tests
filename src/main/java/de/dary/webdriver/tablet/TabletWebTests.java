package de.dary.webdriver.tablet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaMobileDriver;
import com.opera.core.systems.OperaProduct;

public class TabletWebTests {
  @Test
  public void testInOperaMobileBrowser() throws Exception {
    WebDriver driver = new OperaMobileDriver(getNexus7OperaCapabilities());
    checkDailyDealsDE(driver);
  }

  @Test
  public void testInAndroidMobileBrowser() throws Exception {
    WebDriver driver = new AndroidDriver();
    checkDailyDealsDE(driver);
  }

  protected void checkDailyDealsDE(WebDriver driver) throws Exception {
    driver.get("http://deals.ebay.de");
    WebElement header = driver.findElement(By.cssSelector("h1.hb_h1Content"));
    Assert.assertEquals("eBay WOW! Angebote", header.getText());
    WebElement toys = driver.findElement(By.linkText("Spielzeug"));
    toys.click();
    driver.findElement(By.linkText("Kinderspielzeug")).click();
    WebElement toysHeader = driver.findElement(By.cssSelector("span.sp_mainTitleDiv"));
    Assert.assertEquals("Spielzeug- WOW! Angebote", toysHeader.getText());
    driver.findElement(By.cssSelector("input.minPrice")).sendKeys("20");

    driver.findElement(By.cssSelector("input.PriceFilter")).click();
  }

  private void doubleTapElement(WebElement element, WebDriver driver) {
    TouchActions action = new TouchActions(driver);
    action.doubleTap(element);
    action.build().perform();
  }

  private DesiredCapabilities getNexus7OperaCapabilities() {
    DesiredCapabilities c = DesiredCapabilities.opera();
    c.setCapability(
        "opera.binary",
        "/Applications/Opera Mobile Emulator.app/Contents/Resources/Opera Mobile.app/Contents/MacOS/Opera Mobile");
    c.setCapability("opera.product", OperaProduct.MOBILE);
    c.setCapability("opera.arguments", "-tabletui -displaysize 800x1280 -displayzoom 50%");
    return c;
  }
}
