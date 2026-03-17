package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");

        driver.manage().window().maximize();

        Thread.sleep(4000);

        // Click first "Add to Cart" button
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();

        Thread.sleep(4000);

        // Click Continue Shopping
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        System.out.println("\n\n\nFirst item added to cart successfully");

        driver.quit();
    }
}
