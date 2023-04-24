package org.weld.test.example;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.ExplicitParamInjection;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@EnableWeld
@ExplicitParamInjection // that line fixes error like ParameterResolutionException: Weld has failed to resolve test parameter...
class ServiceExampleTest {

    @Inject
    ServiceExample serviceExample;

    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(ServiceExample.class).build();

    // works fine
    @Test
    void worksFine() {
        serviceExample.callSomething("Simple test");
    }

    // org.junit.jupiter.api.extension.ParameterResolutionException: Weld has failed to resolve test parameter [java.lang.String arg0] in method [void org.weld.test.example.ServiceExampleTest.callSomething2(java.lang.String)].
    // Unsatisfied dependency has type java.lang.String and qualifiers [].
    @ParameterizedTest
    @ValueSource(strings = {"1", "Deal1"})
    void doesntWork(String value) {
        serviceExample.callSomething(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "Deal2"})
    void doesntWork2(String value) {
        serviceExample.callSomething(value);
    }

}