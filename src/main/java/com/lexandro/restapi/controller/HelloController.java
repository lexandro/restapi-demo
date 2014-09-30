package com.lexandro.restapi.controller;

import com.lexandro.restapi.message.HelloOutput;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<HelloOutput> helloWorld(@PathVariable("name") String name) {
        HelloOutput resultMessage = new HelloOutput();
        resultMessage.setMessage("Hello " + name);
        return new ResponseEntity<>(resultMessage, OK);
    }

}
