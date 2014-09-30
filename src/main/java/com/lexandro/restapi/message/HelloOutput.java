package com.lexandro.restapi.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

public class HelloOutput extends ResourceSupport {

    @Getter
    @Setter
    private String message;
}
