package co.com.devco.tasks;

import co.com.devco.interactions.Scroll;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.userinterface.CheckoutPage.*;

import static co.com.devco.userinterface.ProductPage.BTN_OPEN_SHOP_CART;

public class Checkout {

    public static Performable checkout() {
        return Task.where(
                actor -> {
                    actor.attemptsTo(Click.on(BTN_OPEN_SHOP_CART));
                    actor.attemptsTo(Scroll.down());
                    actor.attemptsTo(Click.on(BTN_CHECKOUT));
                    actor.attemptsTo(Enter.theValue("Juan").into(TXT_NAME));
                    actor.attemptsTo(Enter.theValue("Fernandez").into(TXT_LAST_NAME));
                    actor.attemptsTo(Enter.theValue("050005").into(TXT_POST_CODE));
                    actor.attemptsTo(Scroll.down());
                    actor.attemptsTo(WaitUntil.the(BTN_CONTINUE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
                    actor.attemptsTo(Click.on(BTN_CONTINUE));
                    actor.attemptsTo(Scroll.down());
                    actor.attemptsTo(WaitUntil.the(BTN_FINISH, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
                    actor.attemptsTo(Click.on(BTN_FINISH));
                }
        );
    }
}
