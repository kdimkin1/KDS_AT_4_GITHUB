package ru.kds.tests.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappDragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }
    @Test
    void herokuappDragAndDrop () {
    //Откройте https://the-internet.herokuapp.com/drag_and_drop
    open("/drag_and_drop");
    //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
    //Проверьте, что прямоугольники действительно поменялись
        $("#column-a > header").shouldHave(text("B"));
        //добавим скриншот
        // build/reports/tests/checkDragAndDrop.png
        String checkJunit5Example = screenshot("checkDragAndDrop");

    }
}
