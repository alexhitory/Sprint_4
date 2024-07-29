package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final WebDriver driver;

        // Локатор кнопки "Заказать" вверху страницы
        private final String orderButtonAtTheTop = ".//button[@class='Button_Button__ra12g']";
        // Локатор кнопки "Заказать" внизу страницы
        private final String orderButtonAtTheBottom = ".//div[@class='Home_FinishButton__1_cWm']/button";
        //Локатор для вопросов FAQ
        private final String locationFieldQuest = ".//div[@id='accordion__heading-%d']";
        //Локатор для ответов FAQ
        private final String locationFieldAnswer = ".//div[@id='accordion__panel-%d']/p";
        //
//    private final String cookieButton =
    public MainPage (WebDriver driver) {
        this.driver = driver;
        }
        //метод для скролла страницы до FAQ
    public MainPage scrollToFaq(int itemIndex) {
        WebElement element = driver.findElement(By.xpath(String.format(locationFieldQuest,itemIndex)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
        //метод для нажатия на поля FAQ
    public MainPage clickOnFaqElement(int itemIndex){
        driver.findElement(By.xpath(String.format(locationFieldQuest,itemIndex))).click();
        return this;
    }
         //метод для получения текста полей FAQ
    public MainPage getFaqElementText(int itemIndex) {
        driver.findElement(By.xpath(String.format(locationFieldAnswer,itemIndex))).getText();
        return this;
    }
    //метод для сравнения текста полей FAQ
    public MainPage testEqualsFaqTest(int itemIndex, String expectedText){
        Assert.assertEquals(driver.findElement(By.xpath(String.format(locationFieldAnswer, itemIndex))).getText(), expectedText);
        return this;
    }
    //Метод для прокрутки главной страницы до кнопки заказать
    public MainPage orderButtonAtTheBottom() {
        WebElement element = driver.findElement(By.xpath(orderButtonAtTheBottom));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    //Метод для нажатия на кнопку "Заказать" внизу страницы
    public MainPage clickBottomButtonOrder() {
        driver.findElement(By.xpath(orderButtonAtTheBottom)).click();
        return this;
    }
    //Метод для нажатия на кнопку "Заказать" вверху страницы
    public MainPage clickTopButtonOrder() {
        driver.findElement(By.xpath(orderButtonAtTheTop)).click();
        return this;
    }

}

