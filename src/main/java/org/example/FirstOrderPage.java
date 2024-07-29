package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstOrderPage {

    private final WebDriver driver;

    // локатор для поля "Имя"
    private final By nameField = By.xpath(".//input[contains(@placeholder, '* Имя')]");
    // локатор для поля "Фамилия"
    private final By surnameField = By.xpath(".//input[contains(@placeholder, '* Фамилия')]");
    // локатор для поля "Адрес: куда привезти заказ"
    private final By addressField = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    // локатор для поля "Станция метро"
    private final By stationField = By.xpath(".//input[contains(@placeholder, '* Станция метро')]");
    // локатор для станции Сокольники в выпадающем списке
    private final By stationSokolniky = By.xpath(".//div[text()='Сокольники']");
    // локатор для поля "Телефон: на него позвонит курьер"
    private final By telephoneField = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    // локатор для кнопки "Далее"
    private final By buttonNext = By.xpath(".//button[text()='Далее']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод для заполнения поля "Имя"
    public FirstOrderPage setNameField(String username) {
        driver.findElement(nameField).sendKeys(username);
        return this;
    }
    // Метод для заполнения поля "Фамилия"
    public FirstOrderPage setFamilyNameField(String userFamilyName) {
        driver.findElement(surnameField).sendKeys(userFamilyName);
        return this;
    }
    // Метод для заполнения поля "Адрес"
    public FirstOrderPage setAddressField(String userAddress) {
        driver.findElement(addressField).sendKeys(userAddress);
        return this;
    }
    // Метод для клика по полю "Станция метро"
    public FirstOrderPage clickStationField() {
        driver.findElement(stationField).click();
        return this;
    }
    // Метод для выбора станции "Сокольники"
    public FirstOrderPage clickStationSokolniky() {
        driver.findElement(stationSokolniky).click();
        return this;
    }
    // Метод для заполнения поля "Телефон: на него позвонит курьер"
    public FirstOrderPage setTelephoneField(String telefone) {
        driver.findElement(telephoneField).sendKeys(telefone);
        return this;
    }
    // Метод для клика по кнопке "Далее"
    public FirstOrderPage clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }
    // Метод для скрола до станции "Сокольники"
    public FirstOrderPage scrollToSokolniky(){
        WebElement element = driver.findElement(stationSokolniky);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
}