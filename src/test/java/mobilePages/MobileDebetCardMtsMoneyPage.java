package mobilePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MobileDebetCardMtsMoneyPage {

    private final SelenideElement mobileCardPng = $x("//img[@src='https://www.mtsbank.ru/upload/static/products/main-cards/mts-dengi-kard.png']");
    private final SelenideElement mobileInputPhone = $x("//input[@name='phoneNumber']");
    private final SelenideElement mobileInputFio = $x("//textarea[@name='fullName']");
    private final SelenideElement mobileInputEmail = $x("//input[@name='email']");

    private final SelenideElement mobileErrorMessagePhone = $x("//div[@class='sc-bdc60983-1 fMIFCG'][1]/div[2]");
    private final SelenideElement mobileErrorMessageFio = $x("//div[@class='sc-bdc60983-1 fMIFCG'][2]/div[2]");
    private final SelenideElement mobileErrorMessageEmail = $x("//div[@class='sc-bdc60983-1 fMIFCG'][3]/div[2]");

    private final SelenideElement card1 = $x("//div[@class='Row-sc-a26adb6c-0 gfbyqz sc-1ed7672a-0 eXLGDZ'][1]");
    private final SelenideElement card2 = $x("//div[@class='Row-sc-a26adb6c-0 gfbyqz sc-1ed7672a-0 eXLGDZ'][2]");

    @Step("Клик на картинку карты")
    public MobileDebetCardMtsMoneyPage pngClick() {
        mobileCardPng.scrollTo().click();
        return this;
    }

    @Step("Заполнение формы оформления карты Телефон")
    public MobileDebetCardMtsMoneyPage enterErrorFormPhone(String phone) {
        mobileInputPhone.sendKeys(phone);
        return this;
    }

    @Step("Заполнение формы оформления карты Фио")
    public MobileDebetCardMtsMoneyPage enterErrorFormFio(String fio) {
        mobileInputFio.sendKeys(fio);
        return this;
    }

    @Step("Заполнение формы оформления карты Email")
    public MobileDebetCardMtsMoneyPage enterErrorFormEmail(String email) {
        mobileInputEmail.sendKeys(email);
        return this;
    }

    @Step("Проверка ошибок при заполнении некорректных данных")
    public MobileDebetCardMtsMoneyPage mobileCheckingFields() {
        mobileErrorMessagePhone.shouldHave(Condition.text("Введите верный номер телефона"));
        mobileErrorMessageFio.shouldHave(Condition.text("Введите точно, как в паспорте"));
        mobileErrorMessageEmail.shouldHave(Condition.text("Введите почту в формате user@email.ru"));
        return this;
    }

    @Step("Проверки на наличие слова 'ДЕБЕТОВАЯ' у карт на странице")
    public MobileDebetCardMtsMoneyPage mobileCheckDebetHeaders() {
        card1.shouldHave(Condition.text("ДЕБЕТОВАЯ"));
        card2.shouldHave(Condition.text("ДЕБЕТОВАЯ"));
        return this;
    }
}
