package org.example.controller;


import org.example.model.Event;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.Stream;

@RestController
public class Hello {

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> streamMessages() {

        Flux<Event> eventFlux = Flux.fromStream(Stream.generate(() -> new Event("Hello from France!", LocalTime.now())));
        Flux<Long> duratioFlux = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(eventFlux, duratioFlux).map(Tuple2::getT1);

    }

    @GetMapping("/health")
    public Event healthCheck() {
        return new Event("Healthy", LocalTime.now());
    }
}
