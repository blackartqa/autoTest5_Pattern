package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldDeliveryRequestSuccess() {

        RegistrationByClientInfo client = DataGenerator.Registration.generate();

        $("[placeholder='Город']").setValue(client.getCity());
        $("[placeholder='Дата встречи']").doubleClick();
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(client.getFirstMeetingDate());
        $("[name='name']").setValue(client.getName());
        $("[name='phone']").setValue(client.getPhoneNumber());
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $("[placeholder='Дата встречи']").doubleClick();
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(client.getSecondMeetingDate());
        $(byText("Запланировать")).click();
        $(byText("Перепланировать")).click();
        $("[data-test-id='success-notification'] .notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + client.getSecondMeetingDate()));

    }
}
