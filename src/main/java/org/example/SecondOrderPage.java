package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondOrderPage {

        private final WebDriver driver;

        // локатор для поля "Когда привезти самокат"
        private final By dateField = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
        // локатор заголовок страницы "Про аренду"
        private final By ofRentHeader = By.xpath(".//div[text()='Про аренду']");
        // локатор для поля "Срок аренды"
        private final By termRentField = By.xpath(".//div[text()='* Срок аренды']");
        // локатор для выбора "сутки" в поле "Срок аренды"
        private final By enterTermRentField = By.xpath(".//div[text()='сутки']");
        // локатор для выбора цвета самоката "Чёрный жемчуг"
        private final By colorField = By.id("black");
        // локатор для поля "Комментарий для курьера"
        private final By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
        // локатор для кнопки "Заказать" в конце страницы
        private final By endOrderButton = By.xpath(".//button[2][text()='Заказать']");
        // локатор для кнопки "Да"
        private final By yesButton = By.xpath(".//button[text()='Да']");
        // локатор для заголовка с результатом заказа "Заказ оформлен"
        private final By resultHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

        public SecondOrderPage(WebDriver driver) {
            this.driver = driver;
        }
        //Метод для заполнения поля "Дата"
        public SecondOrderPage setDateField(String date) {
            driver.findElement(dateField).sendKeys(date);
                return this;
        }
        // Метод для клика по заголовку страницы для снятия фокуса с поля
        public SecondOrderPage clickOfRentHeader() {
            driver.findElement(ofRentHeader).click();
                return this;
        }
        // Метод для слика по полю "Срок аренды"
        public SecondOrderPage clickTermRentField() {
            driver.findElement(termRentField).click();
                return this;
        }
        // Метод для выбора срока аренды из выпадющего списка
        public SecondOrderPage clickEnterTermRentField() {
            driver.findElement(enterTermRentField).click();
                return this;
        }
        // Метод для выбора цвета самоката
        public SecondOrderPage clickColorField() {
            driver.findElement(colorField).click();
                return this;
        }
        // Метод для указания комментария для курьера
        public SecondOrderPage setCommentField(String comment) {
            driver.findElement(commentField).sendKeys(comment);
                return this;
        }
        // Метод для нажатия на кнопку "Заказать" в конце заказа(нижняя кнопка)
        public SecondOrderPage clickEndOrderButton() {
            driver.findElement(endOrderButton).click();
                return this;
        }
        // Метод для клика по кнопке "Да"
        public SecondOrderPage clickYesButton() {
            driver.findElement(yesButton).click();
                return this;
        }
        // Метод для проверки появления на экране текста "Заказ оформлен"
        public SecondOrderPage descriptionFieldResult() {
            Assert.assertTrue(driver.findElement(resultHeader).getText().contains("Заказ оформлен"));
                return this;
        }
    }
