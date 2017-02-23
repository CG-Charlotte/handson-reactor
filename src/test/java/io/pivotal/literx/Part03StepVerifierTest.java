/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.literx;

import io.pivotal.literx.Part03StepVerifier;
import io.pivotal.literx.domain.User;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.Assert.fail;

/**
 * Learn how to use StepVerifier to test Mono, Flux or any other kind of Reactive Streams Publisher.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://next.projectreactor.io/ext/docs/api/reactor/test/StepVerifier.html">StepVerifier Javadoc</a>
 */
public class Part03StepVerifierTest {

	Part03StepVerifier part03StepVerifier = new Part03StepVerifier();
//========================================================================================

	@Test
	public void expectElementsThenComplete() {
		part03StepVerifier.expectFooBarComplete(Flux.just("foo", "bar"));
	}


//========================================================================================

	@Test
	public void expect2ElementsThenError() {
		part03StepVerifier.expectFooBarError(Flux.just("foo", "bar").concatWith(Mono.error(new RuntimeException())));
	}



//========================================================================================

	@Test
	public void expectElementsWithThenComplete() {
		part03StepVerifier.expectSkylerJesseComplete(
				Flux.just(new User("swhite", null, null), new User("jpinkman", null, null)));
	}


//========================================================================================

	@Test
	public void count() {
		part03StepVerifier.expect10Elements(Flux.interval(Duration.ofSeconds(1)).take(10));
	}



//========================================================================================

	@Test
	public void countWithVirtualTime() {
		part03StepVerifier.expect3600Elements(() -> Flux.interval(Duration.ofSeconds(1)).take(3600));
	}



}
