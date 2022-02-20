package com.test.reactivetest.client;

import com.test.reactivetest.model.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User: gardiary
 * Date: 20/02/22, 11.16
 */
public class FooWebClient {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    WebClient client = WebClient.create("http://localhost:8082");

    public void retrieve() {
        Mono<Foo> fooMono = client.get()
                .uri("/foo/{id}", "1")
                .retrieve()
                .bodyToMono(Foo.class);
        fooMono.subscribe(foo -> LOGGER.info("Foo : {}", foo));

        Flux<Foo> fooFlux = client.get()
                .uri("/foo/all")
                .retrieve()
                .bodyToFlux(Foo.class);
        fooFlux.subscribe(foos -> LOGGER.debug("Foo All : {}", foos));
    }
}
