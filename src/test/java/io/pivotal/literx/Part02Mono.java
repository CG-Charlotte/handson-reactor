package io.pivotal.literx;

import java.time.Duration;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/core/docs/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================


	// TODO Return an empty Mono
	Mono<String> emptyMono() {
		return null;
	}

//========================================================================================


	// TODO Return an Mono that never emit any signal
	Mono<String> monoWithNoSignal() {
		return null;
	}

//========================================================================================

	// TODO Return a Mono that contains a "foo" value
	Mono<String> fooMono() {
		return null;
	}

//========================================================================================
	

	// TODO Create a Mono that emits an IllegalStateException
	Mono<String> errorMono() {
		return null;
	}

}
