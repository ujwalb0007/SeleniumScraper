package com.example.selenium;

import com.example.selenium.pages.WikiMainPage;
import com.example.selenium.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;

public class MainScraper {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Initialize WebDriver
        WebDriver driver = WebDriverUtil.getChromeDriver();

        try {
            // Navigate to Wikipedia main page
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            // Initialize page object
            WikiMainPage wikiPage = new WikiMainPage(driver);

            // Extract and print welcome text
            String welcomeText = wikiPage.getWelcomeText();
            System.out.println("Welcome Text: " + welcomeText);

            // Extract and print paragraphs
            wikiPage.getParagraphs().forEach((index, text) ->
                    System.out.println("Paragraph " + index + ": " +
                            (text.length() > 100 ? text.substring(0, 100) + "..." : text)));

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Clean up
            driver.quit();
        }

        System.out.printf("Execution time: %.2f seconds%n",
                (System.currentTimeMillis() - startTime) / 1000.0);
    }
}