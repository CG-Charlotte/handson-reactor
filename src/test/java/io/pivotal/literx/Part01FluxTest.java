package io.pivotal.literx;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Created by charlotte on 22/02/17.
 */
public class Part01FluxTest {
    Part01Flux  part01Flux = new Part01Flux();

    @Test
    public void empty() {
        Flux<String> flux = part01Flux.emptyFlux();

        StepVerifier.create(flux)
                .verifyComplete();
    }

    @Test
    public void fromValues() {
        Flux<String> flux = part01Flux.fooBarFluxFromValues();
        StepVerifier.create(flux)
                .expectNext("foo", "bar")
                .verifyComplete();
    }

    @Test
    public void fromList() {
        Flux<String> flux = part01Flux.fooBarFluxFromList();
        StepVerifier.create(flux)
                .expectNext("foo", "bar")
                .verifyComplete();
    }

    @Test
    public void error() {
        Flux<String> flux = part01Flux.errorFlux();
        StepVerifier.create(flux)
                .verifyError(IllegalStateException.class);
    }

    @Test
    public void countEach100ms() {
        Flux<Long> flux = part01Flux.counter();
        StepVerifier.create(flux)
                .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .verifyComplete();
    }


}
