package de.dary.webdriver.tablet;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaMobileDriver;
import com.opera.core.systems.OperaProduct;

public class TabletWebTests {
  @Test
  public void checkDailyDealsDE() throws Exception {
    WebDriver driver = new OperaMobileDriver(getNexus7OperaCapabilities());
    driver.get("http://deals.ebay.de");
    WebElement header = driver.findElement(By.cssSelector("h1.hb_h1Content"));
    Assert.assertEquals("eBay WOW! Angebote", header.getText());
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
