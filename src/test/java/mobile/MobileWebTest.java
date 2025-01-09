package mobile;

import io.qameta.allure.*;
import mobilePages.MobileDebetCardMtsMoneyPage;
import mobilePages.MobileMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

@Epic("Тесты Mobile")
@Link(name = "Сайт мтс банка", url = "https://www.mtsbank.ru/")
@Owner("Петрушин Вадим Васильевич")
public class MobileWebTest extends BaseTestMobile {

    final static String FIO_ERROR = "Сергей1";
    final static String EMAIL_ERROR = "uka1980bk.ru";


    @Test
    @Description("Проверка на заполнение полей формы дебетовой карты МТС деньги с ошибками и проверка сообщений об ошибках")
    @DisplayName("Проверка на заполнение формы с ошибками")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkErrorForm() {
        open("https://www.mtsbank.ru/");
        MobileMainPage mobileMainPage = new MobileMainPage();
        mobileMainPage.clickMobileButtonDebetCard();

        Random rn = new Random();
        int minimum = 900000000;
        int maximum = 999999999;
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        String randomNumberAsString = String.valueOf(randomNum);

        MobileDebetCardMtsMoneyPage mobileDebetCardMtsMoneyPage = new MobileDebetCardMtsMoneyPage();
        mobileDebetCardMtsMoneyPage.pngClick()
                .enterErrorFormPhone(randomNumberAsString)
                .enterErrorFormFio(FIO_ERROR)
                .enterErrorFormEmail(EMAIL_ERROR)
                .enterErrorFormFio(FIO_ERROR)
                .mobileCheckingFields();
    }

    @Test
    @Description("Проверка на наличие только дебетовых карт в списке при переходе на вкладку 'дебетовые")
    @DisplayName("Проверка на отображение ожидаемых элементов")
    @Severity(SeverityLevel.TRIVIAL)
    public void check1ErrorForm() {
        open("https://www.mtsbank.ru/"); // Замените на ваш URL
        MobileMainPage mobileMainPage = new MobileMainPage();
        mobileMainPage.clickMobileButtonDebetCard();

        MobileDebetCardMtsMoneyPage mobileDebetCardMtsMoneyPage = new MobileDebetCardMtsMoneyPage();
        mobileDebetCardMtsMoneyPage.mobileCheckDebetHeaders();
    }
}