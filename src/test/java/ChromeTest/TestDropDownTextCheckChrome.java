package ChromeTest;

import org.example.BrowserPage;
import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestDropDownTextCheckChrome {
    BrowserPage browserPage = new BrowserPage();
    WebDriver driver = browserPage.chromeDriver();
    private final int locationFaq;
    private final int hiddenFaqText;
    private final String expectedText;

    public TestDropDownTextCheckChrome(int locationFaq, int hiddenFaqText, String expectedText) {
        this.locationFaq = locationFaq;
        this.hiddenFaqText = hiddenFaqText;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void TestDropDownCheck() {
        new MainPage(driver)
                .scrollToFaq(locationFaq)
                .clickOnFaqElement(locationFaq)
                .getFaqElementText(locationFaq)
                .testEqualsFaqTest(hiddenFaqText, expectedText);
    }
    @After
    public void shutdown() {
        driver.quit();
    }
}
