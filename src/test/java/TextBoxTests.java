import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Rus Kudakaev");
        $("#userEmail").setValue("test@test.ru");
        $("#currentAddress").setValue("adress1");
        $("#permanentAddress").setValue("adress2");

        $("#submit").click();

        $("#output div").shouldHave(
                text("Name:Rus Kudakaev"),
                text("test@test.test"),
                text("adress1"),
                text("adress2"));
    }
}
