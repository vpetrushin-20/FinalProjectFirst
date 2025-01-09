package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ModalWindowCredit {

    private final SelenideElement percentOfCredit = $x("//div[@class='sc-fXoxaI haqWHP']//div[1]//div[1]//h4");
    private final SelenideElement taxDeduction = $x("//div[@class='sc-jXktde gZXNMg']//div[@order='3']//h4");
    private final SelenideElement monthlyPayment = $x("//div[@class='sc-fXoxaI haqWHP']//div[1]//div[3]//h4");
    private final SelenideElement sumOfCredit = $x("//div[@class='sc-jXktde gZXNMg']//div[@order='1']//h4");

    @Step("Получение текста у эл-та (проценты)")
    public String percentOfCreditAfter() {
        return percentOfCredit.getText();
    }

    @Step("Получение текста у эл-та (налог)")
    public String taxDeductionAfter() {
        return taxDeduction.getText();
    }

    @Step("Получение текста у эл-та (месячный платеж)")
    public String monthlyPaymentAfter() {
        return monthlyPayment.getText();
    }

    @Step("Получение текста у эл-та (сумма кредита)")
    public String sumOfCreditAfter() {
        return sumOfCredit.getText();
    }

}
