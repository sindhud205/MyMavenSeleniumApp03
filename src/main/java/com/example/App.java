package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        // Automatically set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();

        // Enable headless mode when running in Jenkins
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Click first "Add to Cart"
            By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
            wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

            // Click "Continue Shopping"
            By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
            wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();

            System.out.println("First item added to cart successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
