package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FirstLoanWithoutPercentPage {

    private final SelenideElement tarifStartOformit = $x("//a[text()='Оформить']");

    @Step("Закрытие куки баннера")
    private void closeCookieBanner() {
        try {
            // найти и закрыть куки баннер
            $(".cookie-banner__txt").parent().$("button").click();
        } catch (ElementNotFound e) {
            // Баннера нет - продолжаем выполнение
        }
    }

    @Step("Клик по кнопке 'Оформить' в тарифе 'Старт'")
    public FirstLoanWithoutPercentPage clickOnTarifStartOformit() {
        closeCookieBanner();
        tarifStartOformit.scrollIntoView(true).click();
        return this;
    }
}