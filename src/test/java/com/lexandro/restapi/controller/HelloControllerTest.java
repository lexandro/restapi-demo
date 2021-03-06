package com.lexandro.restapi.controller;


import com.lexandro.restapi.DemoApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApp.class)
@WebAppConfiguration
public class HelloControllerTest {

    public static final String DEMO_NAME = "lexandro";
    @Autowired
    private WebApplicationContext context;
    //
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldHelloWorldGreetsWithParamValueName() throws Exception {
        mockMvc.perform(get("/hello/" + DEMO_NAME).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("Hello " + DEMO_NAME))
                .andReturn();
    }

    @Test
    public void shouldHelloWorldGreetsWithRequestParamName() throws Exception {
        mockMvc.perform(get("/hello?name=" + DEMO_NAME).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("Hello lexandro"))
                .andReturn();
    }

    @Test
    public void shouldHelloWorldGreetsWithPostedBodyName() throws Exception {
        String jsonMessage = DEMO_NAME;
        mockMvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonMessage.getBytes()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("Hello " + DEMO_NAME))
                .andReturn();
    }
}