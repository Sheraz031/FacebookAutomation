package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageTranprancy {

	WebDriver driver;

	public pageTranprancy(WebDriver driver) {
		this.driver = driver;
	}

	public String seeAll() {
		String url = "";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
		}

		int m = 0;
		List<WebElement> elements = driver.findElements(By.xpath(
				"//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh jq4qci2q a3bd9o3v knj5qynh py34i1dx']"));

		elements.get(elements.size() - 1).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<WebElement> element = driver.findElements(By.xpath("//div[@aria-label='Page Transparency']"));
		List<WebElement> element1 = element.get(0).findElements(By.tagName("span"));

		for (int i = 0; i < element1.size(); i++) {
			if (element1.get(i).getText().equalsIgnoreCase("Go To Ad Library")) {
				element1.get(i).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
				}
				String mainWindow = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();
				int ite = 0;

				for (String handle : handles) {
					ite++;
					if (ite == handles.size()) {
						driver.switchTo().window(handle);
						url = driver.getCurrentUrl();
					}
				}

				break;
			}
		}
		return url;
	}
}
