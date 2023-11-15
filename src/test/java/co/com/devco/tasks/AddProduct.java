package co.com.devco.tasks;

import co.com.devco.interactions.NewScroll;
import co.com.devco.interactions.Scroll;
import io.appium.java_client.AppiumBy;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.devco.userinterface.ProductPage.BTN_ADD_TO_CART;

public class AddProduct {

    @Step("Selecciona producto")
    public static Performable toTheCart(String nameProduct) {
        return Task.where(
                actor -> {
                    String locator = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", nameProduct);
                    String iosLocator = String.format("type == 'XCUIElementTypeStaticText' AND label CONTAINS '%s'", nameProduct);
                    Target product = Target.the("Title with the name of the product")
                            .locatedForAndroid(AppiumBy.androidUIAutomator(locator))
                            .locatedForIOS(AppiumBy.iOSNsPredicateString(iosLocator));
                    actor.attemptsTo(Click.on(product));
                    actor.attemptsTo(Scroll.down());
                    actor.attemptsTo(new ClickOnTarget(BTN_ADD_TO_CART));
                }
        );
    }

}


