package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
public class Part08OtherOperations {

	final static User MARIE = new User("mschrader", "Marie", "Schrader");
	final static User MIKE = new User("mehrmantraut", "Mike", "Ehrmantraut");

//========================================================================================


	// TODO Create a Flux of user from Flux of username, firstname and lastname.
	Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
		return null;
	}

//========================================================================================


	// TODO return the mono which returns faster its value
	Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
		return null;
	}

//========================================================================================



	// TODO return the flux which returns faster the first value
	Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
		return null;
	}

//========================================================================================



	// TODO Convert the input Flux<User> to a Mono<Void> that represents the complete signal of the flux
	Mono<Void> fluxCompletion(Flux<User> flux) {
		return null;
	}

//========================================================================================



	// TODO Return a valid Mono of user for null input and non null input user (hint: Reactive Streams does not accept null values)
	Mono<User> nullAwareUserToMono(User user) {
		return null;
	}

//========================================================================================


	// TODO Return the same mono passed as input parameter, expect that it will emit User.SKYLER when empty
	Mono<User> emptyToSkyler(Mono<User> mono) {
		return null;
	}

}
