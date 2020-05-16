package com.demo.framework.utility;

import java.util.List;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	 private Logger log = Log.getLogger(Actions.class);
	    protected Scenario scenario;
	    protected WebDriver driver;
	    protected WebDriverWait wait;
	    private ConfigurationReader configReader;
	    private static String otp = "";

	    public void clickElement(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    }

	    public void enterText(WebElement element, String text) {
	        waitForSeconds(1);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.sendKeys(text);
	        element.sendKeys(Keys.TAB);
	    }

	    public void enterText(String fieldName, String value) {
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]//..//input";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        clearTextBox(element);
	        element.sendKeys(value);
	        waitForSeconds(1);
	        element.sendKeys(Keys.TAB);
	        log.info("Entered " + value + " into " + fieldName);

	    }

	    public void enterText(String fieldName, int value) {
	        waitForLoad();
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]//..//input";
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        List<WebElement> elementList = driver.findElements(By.xpath(XPATH));
	        (elementList.get(elementList.size() - 1)).sendKeys(String.valueOf(value));
	        log.info("Entered " + value + " into " + fieldName);
	    }

	    public String getAttributeValue(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        return element.getAttribute("value");
	    }

	    public String getText(String fieldName) {
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]//..//input";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        return element.getText();
	    }

	    public void selectItemFromDropDown(WebElement element, String itemName) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        Select dropDown = new Select(element);
	        dropDown.selectByVisibleText(itemName);
	    }

	    public void waitForElementToBeClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void waitForElementToBeVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public boolean existsElement(String xPath) {
	        waitForLoad();
	        WebElement element = driver.findElement(By.xpath(xPath));
	        System.out.println("Header: " + element.getText());

	        return true;
	    }

	    public boolean isElementEnabled(String webElementclass) {
	        waitForLoad();
	        WebElement element = driver.findElement(By.className(webElementclass));
	        boolean isElementEnabled = element.isEnabled();
	        return isElementEnabled;
	    }

	    public boolean isElementDisabled(String webElementclass) {
	        waitForLoad();
	        WebElement element = driver.findElement(By.className(webElementclass));
	        boolean isElementEnabled = !element.isEnabled();
	        return isElementEnabled;
	    }

	    public void waitForLoad() {
	        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }

	    public void clickElement(String elementName) {
	        String XPATH = ".//*[contains(text(),'" + elementName + "')]";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        element.click();
	        log.info("Clicked on " + elementName + " element");
	        scenario.write("User Clicked on " + elementName + " option");

	    }

	    public void clickButton(String buttonName) {
	        waitForSeconds(2);
	        String XPATH = "//button[contains(text(),'" + buttonName + "')]";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	        waitForSeconds(1);
	        element.click();
	        log.info("Clicked on " + buttonName + " button");
	        scenario.write(" User Clicked on " + buttonName + " button");
	    }

	    public void clearTextBox(WebElement element) {

	        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);

	        int textLength = element.getAttribute("value").length();
	        while (textLength > 0) {
	            actions.moveToElement(element)
	                    .click()
	                    .sendKeys(Keys.BACK_SPACE)
	                    .build()
	                    .perform();
	            textLength--;
	        }
	    }

	    public String generateSecurityToken(String secretKey) {
	        Totp totp = new Totp(secretKey);
	        String twoFactorCode = totp.now();
	        while (otp.equalsIgnoreCase(twoFactorCode))
	            twoFactorCode = totp.now();
	        otp = twoFactorCode;
	        return twoFactorCode;
	    }

	    public void waitForSeconds(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (Exception e) {

	        }
	    }

	    public String generatePINandSecurityToken(String secretKey, String pin) {
	        waitForSeconds(2);
	        String token = generateSecurityToken(secretKey);
	        System.out.print("pin + token: " + pin + token);
	        return (pin + token);
	    }


//	    public void validateText(String expected, String elementName) {
//	        if (elementName.equalsIgnoreCase("Bank charges")) {
//	            String xpathBankCharges = "//*[contains(text(),'" + elementName + "')]/parent::div/child::div/div";
//	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBankCharges)));
//	            String actual = element.getText();
//	            Assert.assertEquals(actual, expected);
//	        } else {
//	            String XPATH = "//*[contains(text(),'" + elementName + "')]/following::span[1]";
//	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
//	            String actual = element.getText();
//	            Assert.assertEquals(actual, expected);
//	        }
	//
//	    }

	    public void clickElementWithDiv(String elementName) {
	        String XPATH = ".//div[contains(text(),'" + elementName + "')]";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        element.click();
	    }


	    public void retryTokenAndPin(String fieldName, String value, String buttonName) {

	        waitForSeconds(3);
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]//..//input";
	        WebElement element = driver.findElement(By.xpath(XPATH));


	        element.click();
	        element.clear();
	        element.sendKeys(value);
	        //element.sendKeys(Keys.TAB);
	        clickButton(buttonName);


	    }

	    public boolean isButtonEnabled(String fieldName) {
	        waitForLoad();
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]";
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        WebElement element = driver.findElement(By.xpath(XPATH));
	        boolean isButtonEnabled = element.isEnabled();
	        return isButtonEnabled;
	    }

	    public boolean isButtonDisabled(String fieldName) {
	        waitForLoad();
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]";
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        WebElement element = driver.findElement(By.xpath(XPATH));
	        boolean isElementDisabled = !element.isEnabled();
	        return isElementDisabled;
	    }

	    public boolean isElementPresent(String fieldName) {
	        waitForLoad();
	        String XPATH = ".//*[contains(text(),'" + fieldName + "')]";
	        try {
	            driver.findElement(By.xpath(XPATH));
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    public boolean isElementPresentByXpath(String xpath) {
	        waitForLoad();
	        try {
	            driver.findElement(By.xpath(xpath));
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    public void clickActionsLinkOfCustomer(String customerCIN, String linkName, WebDriver webDriver) {
	        waitForSeconds(5);
	        WebElement linkElement = (new WebDriverWait(webDriver, 50))
	                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + customerCIN + "')]/following::div/a[contains(@title,'" + linkName + "')]")));
	        linkElement.click();
	    }

	    public void clickActionsLinkOfUser(String CPID, String linkIcon, WebDriver webDriver) {
	        WebElement linkElement = (new WebDriverWait(webDriver, 50))
	                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + CPID + "')]/following::div/a[contains(@title,'" + linkIcon + "')]")));
	        linkElement.click();
	    }

	    public void clickTab(String tabID) {
	        String XPATH = "//a[contains(@id,'" + tabID + "')]";
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH)));
	        element.click();
	    }
}