package tests;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class ITestTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open Website", () -> {
            open("https://ittest-team.ru/");
        });
        step(" Check Development", () -> {
            $(byText("Подробнее")).click();
            $("h1").shouldHave(text("Разработка"));
        });
        step(" Check About", () -> {
            $(byText("О нас")).click();
            $(".content-wrapper__title").shouldHave(text("о компании"));
        });
        step(" Check Download", () -> {
            $(".btn.view-presentation").download();
            FileUtils.deleteDirectory(new File("./downloads"));
        });
        step(" Check Testing", () -> {
            $("#menu-item-29").click();
            $(byText("Тестирование")).click();
            $("h1").shouldHave(text("тестирование"));
        });
        step(" Check Contacts", () -> {
            $(byText("Контакты")).click();
            $(".info-contacts-links").shouldHave(text("+7 (4872) 52-59-50"));
        });
    }
}
