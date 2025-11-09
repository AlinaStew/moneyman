package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.TestData.INVALID_PASSWORD;
import static utils.TestData.INVALID_PHONE;

@Tag("regression")
@DisplayName("MoneyMan site UI tests")
public class MoneyManTests extends BaseTest {

    @Test
    @Tag("negative")
    @DisplayName("Проверка ввода невалидных данных в форме регистрации")
    public void checkRegistrationWithIncorrectPasswordTest() {
        mainPage.clickPersonalAccount()
                .clickLoginAndPasswordButton()
                .setPhoneNumber(INVALID_PHONE)
                .setPassInput(INVALID_PASSWORD)
                .clickEnterAccountButton();
    }

    @Test
    @DisplayName("Проверка перехода на сайт ГосУслуг")
    public void checkToGosUslugiSite() {
        mainPage.clickGosUslugiButton();
        Selenide.sleep(6000);
        Assertions.assertTrue(url().contains("esia.gosuslugi.ru"),
                "Должен открыться сайт госуслуг. Фактический URL: " + url());
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия формы заявки в пункте 'Связаться с нами' ")
    public void findFormSendARequestAfterClickContactUs() {
        faqContactPage.clickOnContactLink()
                .verifyFormTitleText();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия формы заявки в пункте 'Получить деньги' ")
    public void findFormSendARequestAfterClickGetMoney() {
        mainPage.clickGetMoneyButton();
        clientAreaPage.checkContactForm();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия формы заявки в тарифе 'Старт' ")
    public void checkContactFormOfStartTariff() {
        headerBarPage.clickOnFirstLoanWithoutPercent();
        firstLoanWithoutPercentPage.clickOnTarifStartOformit();
        clientAreaPage.checkContactForm();
    }
}