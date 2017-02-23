package io.pivotal.literx;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/core/docs/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02MonoTest {

	Part02Mono part02Mono = new Part02Mono();
//========================================================================================

	@Test
	public void empty() {
		Mono<String> mono = part02Mono.emptyMono();
		StepVerifier.create(mono)
				.verifyComplete();
	}


//========================================================================================

	@Test
	public void noSignal() {
		Mono<String> mono = part02Mono.monoWithNoSignal();
		StepVerifier
				.create(mono)
				.expectSubscription()
				.expectNoEvent(Duration.ofSeconds(1))
				.thenCancel()
				.verify();
	}



//========================================================================================

	@Test
	public void fromValue() {
		Mono<String> mono = part02Mono.fooMono();
		StepVerifier.create(mono)
				.expectNext("foo")
				.verifyComplete();
	}


//========================================================================================

	@Test
	public void error() {
		Mono<String> mono = part02Mono.errorMono();
		StepVerifier.create(mono)
				.verifyError(IllegalStateException.class);
	}



}
