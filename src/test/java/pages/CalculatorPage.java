package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class CalculatorPage {


    private final SelenideElement firstValueForCalculate = $x("//div[@label='Стоимость недвижимости']//input");
    private final SelenideElement secondValueForCalculate = $x("//div[@label='Срок кредита']//input");
    private final SelenideElement percentOfCredit = $x("//div[@class='sc-flMpop cDAQxN']//div[4]//div");
    private final SelenideElement taxDeduction = $x("//div[@class='sc-flMpop cDAQxN']//div[6]//h4");
    private final SelenideElement monthlyPayment = $x("//*[@id='form']/div/form/div[3]/div[2]/div/div[3]/div[1]/div[1]/h4");
    private final SelenideElement sumOfCredit = $x("//div[@class='Inner-sc-1rfqasg-0 hTQma']//div[3]//h4");
    private final SelenideElement buttonModal = $x("//button[@class='Wrapper-sc-48arcs-1 bVcWGC']");

    @Step("Ввод первого значения в калькулятор")
    public CalculatorPage selectFirstValue(String valueString) {
        firstValueForCalculate.scrollTo().click();

        for (int i = 0; i < 8; i++) {
            firstValueForCalculate.sendKeys(Keys.BACK_SPACE);
        }

        firstValueForCalculate.sendKeys(valueString);
        return this;
    }

    @Step("Ввод второго значения в калькулятор")
    public CalculatorPage selectSecondValue(String valueString) {
        secondValueForCalculate.scrollTo().click();

        for (int i = 0; i < 2; i++) {
            secondValueForCalculate.sendKeys(Keys.BACK_SPACE);
        }

        secondValueForCalculate.sendKeys(valueString);
        return this;
    }

    @Step("Клик на открытие модального окна 'График платежей'")
    public CalculatorPage clickModalWindow() {
        buttonModal.click();
        return this;
    }

    @Step("Получение текста у эл-та (проценты)")
    public String percentOfCreditBefore() {
        return percentOfCredit.getText();
    }

    @Step("Получение текста у эл-та (налог)")
    public String taxDeductionBefore() {
        return taxDeduction.hover().getText();
    }

    @Step("Получение текста у эл-та (месячный платеж)")
    public String monthlyPaymentBefore() {
        return monthlyPayment.getText();
    }

    @Step("Получение текста у эл-та (сумма кредита)")
    public String sumOfCreditBefore() {
        return sumOfCredit.getText();
    }
}
