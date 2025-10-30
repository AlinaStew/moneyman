package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderBarPage {

    private final SelenideElement productsLink = $x("//a[text()='Продукты']"),
            firstLoanWithoutPercent = $x("//a[text()='Первый заем без процентов']");



    @Step("Клик по пункту 'Первый заем без процентов'")
    public HeaderBarPage clickOnFirstLoanWithoutPercent() {
        productsLink.hover();
        firstLoanWithoutPercent.click();
        return this;
    }
}
