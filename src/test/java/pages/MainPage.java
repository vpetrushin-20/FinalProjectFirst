package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$x;

public class MainPage {


    private final SelenideElement creditButton = $x("//div//a[@href='/chastnim-licam/ipoteka/'][contains(text(),'Ипотека')]");
    private final SelenideElement calculateButton = $x("//a[@href='/chastnim-licam/ipoteka/ipotechnyj-kalkulyator/']");
    private final SelenideElement cardsButton = $x("//a[@href='/chastnim-licam/karti/'][contains(text(),'Карты')]");
    private final SelenideElement creditCardMtsMoneyButton = $x("//a[contains(text(),'Кредитная карта МТС Деньги')]");
    private final SelenideElement buttonOfficeMap = $x("//a[@data-testid='link'][contains(text(),'Офисы')]");
    private final SelenideElement buttonAcceptCity = $x("//div[@class='styled__GridContainer-sc-60680798-0 gELUGB']//button[1]");
    private final SelenideElement buttonSmallBusiness = $x("//a[@href='/malomu-biznesu/']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    @Step("Нажатие на кнопку 'Ипотека'")
    public MainPage clickCreditButton() {
        creditButton.click();
        return this;
    }

    @Step("Нажатие на кнопку 'Ипотечный калькулятор'")
    public MainPage clickCalculateButton() {
        calculateButton.hover().click();
        return this;
    }

    @Step("Клик на поле 'Карты'")
    public MainPage clickCardsButton() {
        cardsButton.click();
        return this;
    }

    @Step("Клик на поле 'Кредитная карта МТС деньги'")
    public MainPage clickCreditCardMtsMoneyButton() {
        creditCardMtsMoneyButton.click();
        return this;
    }

    @Step("Нажатие на поле 'Офисы и банкоматы'")
    public MainPage clickButtonOffice() {
        if (buttonAcceptCity.isDisplayed()) {
            buttonAcceptCity.click();
        }
        buttonOfficeMap.click();
        return this;
    }

    @Step("Клик на поле 'Малый бизнес и ИП'")
    public MainPage clickSmallBusinessButton() {
        buttonAcceptCity.click();
        buttonSmallBusiness.click();
        return this;
    }


}
