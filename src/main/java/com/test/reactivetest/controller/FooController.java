package com.test.reactivetest.controller;

import com.test.reactivetest.model.Foo;
import com.test.reactivetest.repository.FooRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * User: gardiary
 * Date: 20/02/22, 10.13
 */
@RestController
@RequestMapping("/foo")
public class FooController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private FooRepository fooRepository;

    @GetMapping("/{id}")
    private Mono<Foo> getById(@PathVariable Long id) {
        LOGGER.info("Accessing getById : {}", id);
        return Mono.just(fooRepository.getById(id));
    }

    @GetMapping(path = "/{id}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> streamById(@PathVariable Long id) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> fooRepository.getById(id));
    }

    @GetMapping("/all")
    private Flux<Foo> getAll() {
        LOGGER.info("Accessing getAll");
        return fooRepository.getAll();
    }
}
