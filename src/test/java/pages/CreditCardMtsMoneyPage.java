package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CreditCardMtsMoneyPage {


    private final SelenideElement confirmCreditButton = $x("//div[@class='styled__ContentWrapper-sc-44ximf-2 jrYhjd']//button");
    private final SelenideElement inputNumber = $x("//input[@name='phoneNumber']");
    private final SelenideElement inputFio = $x("//textarea[@name='clientFio']");
    private final SelenideElement inputEmail = $x("//input[@name='email']");
    private final SelenideElement inputDate = $x("//input[@name='birthDate']");
    private final SelenideElement svgDate = $x("//i[@data-testid='icon_baseX24/calendar-fill']");
    private final SelenideElement svgDateCurrent = $x("//div[@data-testid='Calendar']/div//div[9]");

    private final SelenideElement errorMessagePhone = $x("//div[@class='GridCell-sc-1r7lma1-0 eFNfJO']/div[2]");
    private final SelenideElement errorMessageFio = $x("//div[@class='GridContainer-bor1ho-0 styled__GridContainerWithIndent-sc-1cbcccs-1 knzwKR jDbGgu']/div[2]/div[2]");
    private final SelenideElement errorMessageEmail = $x("//div[@class='GridContainer-bor1ho-0 styled__GridContainerWithIndent-sc-1cbcccs-1 knzwKR jDbGgu']/div[4]/div[2]");

    @Step("Клик на кнопку 'офомить карту'")
    public void clickConfirmCreditButton() {
        confirmCreditButton.click();
    }

    @Step("Ввод телефона в форму")
    public CreditCardMtsMoneyPage enterPhoneNumber(String number) {
        inputNumber.sendKeys(number);
        return this;
    }

    @Step("Ввод ФИО в форму")
    public CreditCardMtsMoneyPage enterFio(String fio) {
        inputFio.sendKeys(fio);
        return this;
    }

    @Step("Ввод EMAIL в форму")
    public CreditCardMtsMoneyPage enterEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    @Step("Клик на поле выбора даты")
    public CreditCardMtsMoneyPage clickBirthInput() {
        inputDate.click();
        return this;
    }

    @Step("Выбор даты в форме")
    public CreditCardMtsMoneyPage setDate() {
        svgDate.click();
        svgDateCurrent.click();
        return this;
    }

    @Step("Проверка отсутствия ошибок при заполнении формы")
    public CreditCardMtsMoneyPage checkingFieldsNoErrors() {
        errorMessagePhone.shouldNotBe(visible);
        errorMessageFio.shouldNotBe(visible);
        errorMessageEmail.shouldNotBe(visible);
        return this;
    }

    @Step("Проверка текста ошибок формы")
    public CreditCardMtsMoneyPage checkingFields() {
        errorMessagePhone.shouldHave(Condition.text("Введите верный номер телефона"));
        errorMessageFio.shouldHave(Condition.text("Используйте только кириллицу"));
        errorMessageEmail.shouldHave(Condition.text("Введите верный электронный адрес"));
        return this;
    }
}

