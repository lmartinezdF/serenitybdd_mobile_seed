package co.com.devco.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletadoPage {

    public static final Target LBL_CHECKOUT_COMPLETE = Target.the("Title Checkout Complete").locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']"))
            .locatedForIOS(AppiumBy.accessibilityId("CHECKOUT: COMPLETE!"));

}