package com.test.reactivetest.repository;

import com.test.reactivetest.model.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import java.util.*;

/**
 * User: gardiary
 * Date: 20/02/22, 10.14
 */
@Repository
public class FooRepository {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static Map<Long, Foo> fooMap;

    static {
        fooMap = new HashMap<>();
        fooMap.put(1L, new Foo(1L, "Foo One"));
        fooMap.put(2L, new Foo(2L, "Foo Two"));
        fooMap.put(3L, new Foo(3L, "Foo Three"));
        fooMap.put(4L, new Foo(4L, "Foo Four"));
        fooMap.put(5L, new Foo(5L, "Foo Five"));
        fooMap.put(6L, new Foo(6L, "Foo Six"));
        fooMap.put(7L, new Foo(7L, "Foo Seven"));
        fooMap.put(8L, new Foo(8L, "Foo Eight"));
        fooMap.put(9L, new Foo(9L, "Foo Nine"));
        fooMap.put(10L, new Foo(10L, "Foo Ten"));
    }

    /*public Mono<Foo> getById(Long id) {
        LOGGER.info("Retrieving getById : " + id);
        return Mono.just(fooMap.get(id));
    }*/

    public Foo getById(Long id) {
        return fooMap.get(id);
    }

    public Flux<Foo> getAll() {
        return Flux.fromIterable(fooMap.values());
    }
}
