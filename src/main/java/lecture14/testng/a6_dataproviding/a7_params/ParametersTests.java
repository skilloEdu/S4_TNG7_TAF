package com.n3qa.lecture14.testng.a6_dataproviding.a7_params;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTests {
    @Parameters({"fullName"})
    @Test
    // use @Optional("Dqdo Mraz") for name in local run without config
    public void testSingleParameter(@Optional("guest") String name) {
        System.out.println("My name is " + name);
    }

    @Parameters({"num1", "num2"})
    @Test
    public void testMultiParameters(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(num1 + "+" + num2 + "=" + result);
    }

    @Parameters({"user-name"})
    @Test
    public void testOptionalParameter(@Optional("guest") String user) {
        System.out.println("Welcome " + user);
    }
}