package mobilePages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MobileMainPage {


    private final SelenideElement mobileButtonDebetCard = $x("//div[@data-testid='navigation-card-grid']/a[1]");

    @Step("Клик на поле 'Дебетовые'")
    public MobileMainPage clickMobileButtonDebetCard() {
        mobileButtonDebetCard.scrollTo().click();
        return this;
    }
}
