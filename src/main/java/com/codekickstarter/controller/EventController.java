package com.codekickstarter.controller;

import com.codekickstarter.representation.EventRepresentation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

    @RequestMapping(method = RequestMethod.POST)
    public EventRepresentation createEvent(@Valid @RequestBody EventRepresentation event) {
        return event;
    }

}
