package test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CheckHowToDonateGitHub extends TestBase{
    @Test
    public void checkHowToDonateGitHub() {
        step("Open GitHub Page", () -> {
            open("https://github.com/");
        });
        step("Hover over the open source section and click on gitHub sponsors", () -> {
            $(".header-menu-wrapper").$(byText("Open Source")).hover();
            $$(".HeaderMenu-dropdown-link").findBy(text("GitHub Sponsors")).click();
        });
        step("Check GitHub sponsors page has header 'Invest in the software that powers your world'", () -> {
            $("div h1").shouldHave(text("Invest in the software that powers your world"));
        });
        step("Click on 'Get Sponsored' button and check registration page has 'Sign in to GitHub' header", () -> {
            $$(".btn-mktg").findBy(text("Get Sponsored")).click();
            $(".auth-form-header").shouldHave(text("Sign in to GitHub"));
        });
    }
}
