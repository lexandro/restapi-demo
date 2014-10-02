package com.lexandro.restapi.controller;

import com.lexandro.restapi.message.HelloOutput;
import com.lexandro.restapi.service.HelloService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private HelloService helloService;

    @Inject
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<HelloOutput> helloWorldPathParam(@PathVariable("name") String name) {
        return createHelloResponse(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<HelloOutput> helloWorldRequestParam(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return createHelloResponse(name);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<HelloOutput> helloWorldPostName(@RequestBody String name) {
        return createHelloResponse(name);
    }

    private ResponseEntity<HelloOutput> createHelloResponse(String name) {
        HelloOutput resultMessage = new HelloOutput();
        resultMessage.setMessage(helloService.sayHello(name));
        return new ResponseEntity<>(resultMessage, OK);
    }


}
