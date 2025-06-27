package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WikiMainPage {
    private WebDriver driver;
    private By welcomeLocator = By.id("mp-welcome");
    private By paragraphLocator = By.tagName("p");

    public WikiMainPage(WebDriver driver) {
        this.driver = driver;
        // Wait for page to load
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(welcomeLocator));
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeLocator).getText();
    }

    public Map<Integer, String> getParagraphs() {
        Map<Integer, String> paragraphs = new HashMap<>();
        List<WebElement> paragraphElements = driver.findElements(paragraphLocator);
        for (int i = 0; i < paragraphElements.size(); i++) {
            paragraphs.put(i + 1, paragraphElements.get(i).getText());
        }
        return paragraphs;
    }
}