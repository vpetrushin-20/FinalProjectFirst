package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ExpressCreditPage {

    private final SelenideElement creditsButton = $x("//div[@class='HeaderLine-sc-17cnhtt-0 erguSP']//div[6]");
    private final SelenideElement expressCreditButton = $x("//a[@href='/malomu-biznesu/krediti/ekspress-overdrafts/'][contains(text(),'Экспресс-кредит')]");
    private final SelenideElement getCreditButton = $x("//div[@class='styled__Wrapper-sc-44ximf-1 cajWZS']//button");
    private final SelenideElement inputFullName = $x("//textarea[@name='fullName']");
    private final SelenideElement inputPhoneNumber = $x("//input[@name='phone']");
    private final SelenideElement inputOffice = $x("//input[@placeholder='Выберите офис']");
    private final SelenideElement inputEmail = $x("//input[@name='email']");
    private final SelenideElement inputInn = $x("//input[@name='inn']");
    private final SelenideElement inputCity = $x("//input[@placeholder='Введите название города']");
    private final SelenideElement confirmCity = $x("//ul[@role='listbox']//li[contains(text(),'Москва')]");
    private final SelenideElement confirmOffice = $x("//ul[@role='listbox']//li[contains(text(),'Мясницкой')]");
    private final SelenideElement confirmFieldOne = $x("//form//div[10]//label/div[1]");
    private final SelenideElement confirmFieldTwo = $x("//form//div[12]//label/div[1]");
    private final SelenideElement confirmFile = $x("//input[@type='file']");
    private final SelenideElement enterForm = $x("//form//button");
    private final SelenideElement errorText = $x("//form/div[7]");


    @Step("Клик на поле 'Кредиты и гарантии', клик на элемент из выпадающего списка 'Экспресс-кредит', клик на 'Получить кредит'")
    public ExpressCreditPage openCreditForm() {
        creditsButton.hover().click();
        expressCreditButton.click();
        getCreditButton.click();
        return this;
    }

    @Step("Заполнение поля ФИО")
    public ExpressCreditPage completeFormFio(String fio) {
        inputFullName.sendKeys(fio);
        return this;
    }

    @Step("Заполнение поля Телефон")
    public ExpressCreditPage completeFormPhone(String phone) {
        inputPhoneNumber.sendKeys(phone);
        return this;
    }

    @Step("Заполнение поля Email")
    public ExpressCreditPage completeFormEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    @Step("Заполнение поля ИНН")
    public ExpressCreditPage completeFormInn(String inn) {
        inputInn.sendKeys(inn);
        return this;
    }

    @Step("Заполнение поля Город и клик на первый эл-т выпадающего списка")
    public ExpressCreditPage completeFormCity(String city) {
        inputCity.sendKeys(city);
        confirmCity.click();
        return this;
    }

    @Step("Заполнение поля офис и клик на первый эл-т выпадающего списка")
    public ExpressCreditPage completeFormOffice() {
        inputOffice.click();
        confirmOffice.click();
        return this;
    }

    @Step("Клик на соглашения с условиями")
    public ExpressCreditPage completeFields() {
        confirmFieldOne.click();
        confirmFieldTwo.scrollTo().click();
        return this;
    }

    @Step("Загрузка файла неверного формата")
    public ExpressCreditPage completeFile() {
        File fileToUpload = new File("src/main/resources/docs/File_For_Test1.docx");
        confirmFile.uploadFile(fileToUpload);
        return this;
    }

    @Step("Клик на кнопку 'Отправить заявку'")
    public ExpressCreditPage clickEnterForm() {
        enterForm.click();
        return this;
    }

    @Step("Проверка текста ошибки при загрузке файла неверного формата")
    public ExpressCreditPage checkErrorText() {
        errorText.shouldHave(Condition.text("Проверьте формат файла. Допустимый формат: .xls/.xlsx"));
        return this;
    }

}
