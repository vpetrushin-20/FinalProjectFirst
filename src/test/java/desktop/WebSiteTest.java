package desktop;

import io.qameta.allure.*;

import org.junit.jupiter.api.DisplayName;
import pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

@Epic("Тесты Desktop")
@Link(name = "Сайт мтс банка", url = "https://www.mtsbank.ru/")
@Owner("Петрушин Вадим Васильевич")
public class WebSiteTest extends BaseTestDesktop {

    private final static String BASE_URL = "https://www.mtsbank.ru/ ";
    final static String FIO_ERROR = "Сергей1";
    final static String EMAIL_ERROR = "uka1980bk.ru";
    final static String PHONE_NUMBER = "9999999999";
    final static String FIO = "Вавилов Сергей Иванович";
    final static String EMAIL = "uka11980@bk.ru";
    final static String INN = "6316000632";
    final static String CITY = "Москва";

    @Test
    @Description("Проверка на соотвествие данных при заполнении ипотечного калькулятора и данных на графике платежей")
    @DisplayName("Проверка соответсвтия данных формы и модального окна")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkInfoFromCredit() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickCreditButton()
                .clickCalculateButton();

        Random rn = new Random();
        int minimum = 25000000;
        int maximum = 30000000;
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        String randomNumberAsString = String.valueOf(randomNum);

        Random rn2 = new Random();
        int minimum2 = 15;
        int maximum2 = 20;
        int range2 = maximum2 - minimum2 + 1;
        int randomNum2 = rn2.nextInt(range2) + minimum2;
        String randomNumberAsString2 = String.valueOf(randomNum2);

        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.selectFirstValue(randomNumberAsString)
                .selectSecondValue(randomNumberAsString2);

        String valueOneBefore = calculatorPage.percentOfCreditBefore();
        String valueTwoBefore = calculatorPage.taxDeductionBefore();
        String valueThreeBefore = calculatorPage.monthlyPaymentBefore();
        String valueFourBefore = calculatorPage.sumOfCreditBefore();

        calculatorPage.clickModalWindow();

        ModalWindowCredit modalWindowCredit = new ModalWindowCredit();

        String valueOneAfter = modalWindowCredit.percentOfCreditAfter();
        String valueTwoAfter = modalWindowCredit.taxDeductionAfter();
        String valueThreeAfter = modalWindowCredit.monthlyPaymentAfter();
        String valueFourAfter = modalWindowCredit.sumOfCreditAfter();

        Assertions.assertEquals(valueOneBefore, valueOneAfter);
        Assertions.assertEquals(valueTwoBefore, valueTwoAfter);
        Assertions.assertEquals(valueThreeBefore, valueThreeAfter);
        Assertions.assertEquals(valueFourBefore, valueFourAfter);

    }

    @Test
    @Description("Проверка текстовых сообщений с указанием ошибок в заполнении формы на кредитную карту МТС деньги")
    @DisplayName("Проверка текста ошибок в заполнении формы")
    @Severity(SeverityLevel.MINOR)
    public void checkInteringTheFormCardError() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickCardsButton()
                .clickCreditCardMtsMoneyButton();

        Random rn = new Random();
        int minimum = 900000000;
        int maximum = 999999999;
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        String randomNumberAsString = String.valueOf(randomNum);

        CreditCardMtsMoneyPage creditCardMtsMoneyPage = new CreditCardMtsMoneyPage();
        creditCardMtsMoneyPage.clickConfirmCreditButton();
        creditCardMtsMoneyPage.enterPhoneNumber(randomNumberAsString)
                .enterFio(FIO_ERROR)
                .enterEmail(EMAIL_ERROR)
                .clickBirthInput()
                .checkingFields();
    }

    @Test
    @Description("Проверка корректного заполнения формы на кредитную карту МТС деньги")
    @DisplayName("Проверка корректного заполнения данных формы")
    @Severity(SeverityLevel.CRITICAL)
    public void checkInteringTheFormCardTrue() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickCardsButton()
                .clickCreditCardMtsMoneyButton();

        CreditCardMtsMoneyPage creditCardMtsMoneyPage = new CreditCardMtsMoneyPage();
        creditCardMtsMoneyPage.clickConfirmCreditButton();
        creditCardMtsMoneyPage.enterPhoneNumber(PHONE_NUMBER)
                .enterFio(FIO)
                .enterEmail(EMAIL)
                .clickBirthInput()
                .setDate()
                .checkingFieldsNoErrors();
    }

    @Test
    @Description("Проверка на налииче пандуса у элементов списка 'Офисы и банкоматы' при выборе фильтра 'Оборудован пандусом'")
    @DisplayName("Проверка на правильную роботу фильтра")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkValuesOffice() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickButtonOffice();

        MapPage mapPage = new MapPage();
        mapPage.enterPandusFilter()
                .checkValueFilterInList();
    }

    @Test
    @Description("Проверка на ожидание ошибки при загрузки файла неверного формата в форме оформления экспресс-кредита")
    @DisplayName("Проверка на ошибку при загрузке файла")
    @Severity(SeverityLevel.BLOCKER)
    public void checkErrorFile() throws IOException {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickSmallBusinessButton();

        ExpressCreditPage expressCreditPage = new ExpressCreditPage();
        expressCreditPage.openCreditForm()
                .completeFormFio(FIO)
                .completeFormPhone(PHONE_NUMBER)
                .completeFormEmail(EMAIL)
                .completeFormInn(INN)
                .completeFormCity(CITY)
                .completeFormOffice()
                .completeFields()
                .completeFile()
                .clickEnterForm()
                .checkErrorText();
    }
}
