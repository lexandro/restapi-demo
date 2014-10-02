package com.lexandro.restapi.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultHelloServiceTest {

    private DefaultHelloService helloService;

    @Before
    public void setUp() throws Exception {
        helloService = new DefaultHelloService();
    }

    @Test
    public void shouldSayHelloGreetTheGivenName() throws Exception {
        // when
        String actualResult = helloService.sayHello("lexandro");
        // then
        assertEquals("Hello lexandro", actualResult);
    }
}