package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addsPage {

	ArrayList<String> urlsList = new ArrayList<String>();
	ArrayList<WebElement> driverList = new ArrayList<WebElement>();

	@FindBy(how = How.XPATH, using = "//div[@class='a53abz89 rgsc13q7 dfy4e4am rwb8dzxj diwav8v6 yukb02kx apktr6ye tlhxvphw']")
	@CacheLookup
	WebElement selectAll;

	WebDriver driver;

	public addsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> Adds() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
		}

		int m = 0;
		selectAll.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<WebElement> elem = driver.findElements(By.xpath(
				"//input[@class='e92713mn svsqgeze lftrkhxp jeej7n5h qbdq5e12 j90q0chr rbzcxh88 h8e39ki1 eq4fccyu qnavoh4n rjrpm8ub pu1cs6ci tds9wb2m i6alm2u7']"));
		elem.get(1).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
		}

		List<WebElement> element = driver.findElements(By.xpath("//div[@role='heading']"));
		for (int i = 0; i < element.size(); i++) {

			List<WebElement> element22 = driver.findElements(By.xpath("//div[@role='heading']"));
			WebElement ele = element22.get(i);
			if (ele.getText().equalsIgnoreCase("See Ad Details")) {
				ele.click();
				driverList.add(ele);
				new addsDetails(driver).printDetial();

			}
		}

		return driverList;
	}

	public String getUrl() {
		int ite = 0;
		String url = "";
		WebDriver mydriver = driver;
		Set<String> handles = mydriver.getWindowHandles();
		for (String handle : handles) {
			ite++;
			if (ite == handles.size()) {
				mydriver.switchTo().window(handle);
				url = mydriver.getCurrentUrl();
			}
		}
		return url;
	}
}
