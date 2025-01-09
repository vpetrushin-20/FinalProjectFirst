package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MapPage {

    private final SelenideElement buttonFilters = $x("//div[@class='styled__Container-sc-1m80q5x-0 dbbrBq']/div[1]/div[1]");
    private final SelenideElement pandusFilter = $x("//div[@class='styled__Container-sc-8qcbi-0 oSLlP']//div[21]//div/div");
    private final SelenideElement buttonList = $x("//div[@data-testid='tabsbar']//button[2]");
    private final ElementsCollection checkList = $$x("//div[@data-testid='tabpanel']");

    @Step("Выбор фильтра 'Есть пандус'")
    public MapPage enterPandusFilter() {
        buttonFilters.click();
        pandusFilter.scrollTo().click();
        buttonFilters.click();
        buttonList.click();
        return this;
    }

    @Step("Проверка наличия текста 'Оборудован пандусом у каждого эл-та списка'")
    public MapPage checkValueFilterInList() {
        for (SelenideElement element : checkList) {
            String expectedText = "Оборудован пандусом";
            element.shouldHave(Condition.text(expectedText));
        }
        return this;
    }

}
