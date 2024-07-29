package FireFoxTest;

import org.example.BrowserPage;
import org.example.FirstOrderPage;
import org.example.MainPage;
import org.example.SecondOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

//Прогон тестового сценария на браузере FireFox
@RunWith(Parameterized.class)
    public class ScooterOrderFireFoxTest {
    BrowserPage browserPage = new BrowserPage();
    WebDriver driver = browserPage.fireFoxDriver();
        private final String name;
        private final String family;
        private final String address;
        private final String telephone;
        private final String date;
        private final String comment;
        public ScooterOrderFireFoxTest (String name, String family, String address, String telephone, String date, String comment) {

            this.name = name;
            this.family = family;
            this.address = address;
            this.telephone = telephone;
            this.date = date;
            this.comment = comment;

        }
        @Before
        public void setUp() {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://qa-scooter.praktikum-services.ru/");
        }

        @Parameterized.Parameters
        public  static  Object[][] getCredentials() {
            return new Object[][] {
                    {"Алексей", "Иванов", "ул. Сокольническая Слободка,7","+79999999999", "25.07.2024", "Комментарий"},
                    {"Сергей", "Довлатов", "Русаковская ул.,24", "+79998887744", "25.07.2024", ""}
            };
        }
    //тест для кнопки заказать вверху страницы
    @Test
    public void OrderChromeTestTopButton() {
        new MainPage(driver)
                .clickTopButtonOrder();
        //Заполнение первой страницы заказа
        new FirstOrderPage(driver)
                .setNameField(name)
                .setFamilyNameField(family)
                .setAddressField(address)
                .clickStationField()
                .scrollToSokolniky()
                .clickStationSokolniky()
                .setTelephoneField(telephone)
                .clickButtonNext();
        //Заполнение второй страницы заказа
        new SecondOrderPage(driver)
                .setDateField(date)
                .clickOfRentHeader()
                .clickTermRentField()
                .clickEnterTermRentField()
                .clickColorField()
                .setCommentField(comment)
                .clickEndOrderButton()
                .clickYesButton()
                .descriptionFieldResult();
    }
    //тест для кнопки заказать внизу страницы
    @Test
    public void OrderChromeTestBottomButton() {
        //Прокрутка до кнопки заказать внизу страницы
        new MainPage(driver)
                .orderButtonAtTheBottom()
                .clickBottomButtonOrder();
        //Заполнение первой страницы заказа
        new FirstOrderPage(driver)
                .setNameField(name)
                .setFamilyNameField(family)
                .setAddressField(address)
                .clickStationField()
                .scrollToSokolniky()
                .clickStationSokolniky()
                .setTelephoneField(telephone)
                .clickButtonNext();
        //Заполнение второй страницы заказа
        new SecondOrderPage(driver)
                .setDateField(date)
                .clickOfRentHeader()
                .clickTermRentField()
                .clickEnterTermRentField()
                .clickColorField()
                .setCommentField(comment)
                .clickEndOrderButton()
                .clickYesButton()
                .descriptionFieldResult();
    }
    @After
    public void shutdown() {
        driver.quit();
    }
}
