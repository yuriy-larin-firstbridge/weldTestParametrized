package org.weld.test.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceExample {

    void callSomething(String inputParam) {
        System.out.println("Called callSomething with " + inputParam);
    }

}
