package be.gerard.features;

import be.gerard.features.steps.ApplicationRestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.rest.rules.RestConfigurationAction;
import net.serenitybdd.rest.rules.RestConfigurationRule;
import net.thucydides.core.annotations.Steps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * WhenApplication
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RunWith(SerenityRunner.class)
public class WhenApplication {

    @Rule
    public RestConfigurationRule rule = new RestConfigurationRule((RestConfigurationAction) () -> SerenityRest.setDefaultBasePath("rest/applications"));

    @Steps
    private ApplicationRestSteps applicationRestSteps;

    @Test
    public void test() {
        // WHEN
        applicationRestSteps.whenPing();

        // THEN
        applicationRestSteps.thenCheckOutcome();
    }

}
