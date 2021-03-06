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
public class Part08OtherOperationsTest {

	final static User MARIE = new User("mschrader", "Marie", "Schrader");
	final static User MIKE = new User("mehrmantraut", "Mike", "Ehrmantraut");

	Part08OtherOperations part08OtherOperations = new Part08OtherOperations();

//========================================================================================

	@Test
	public void zipFirstNameAndLastName() {
		Flux<String> usernameFlux = Flux.just(User.SKYLER.getUsername(), User.JESSE.getUsername(), User.WALTER.getUsername(), User.SAUL.getUsername());
		Flux<String> firstnameFlux = Flux.just(User.SKYLER.getFirstname(), User.JESSE.getFirstname(), User.WALTER.getFirstname(), User.SAUL.getFirstname());
		Flux<String> lastnameFlux = Flux.just(User.SKYLER.getLastname(), User.JESSE.getLastname(), User.WALTER.getLastname(), User.SAUL.getLastname());
		Flux<User> userFlux = part08OtherOperations.userFluxFromStringFlux(usernameFlux, firstnameFlux, lastnameFlux);
		StepVerifier.create(userFlux)
				.expectNext(User.SKYLER, User.JESSE, User.WALTER, User.SAUL)
				.verifyComplete();
	}



//========================================================================================

	@Test
	public void fastestMono() {
		ReactiveRepository<User> repository1 = new ReactiveUserRepository(MARIE);
		ReactiveRepository<User> repository2 = new ReactiveUserRepository(250, MIKE);
		Mono<User> mono = part08OtherOperations.useFastestMono(repository1.findFirst(), repository2.findFirst());
		StepVerifier.create(mono)
				.expectNext(MARIE)
				.verifyComplete();

		repository1 = new ReactiveUserRepository(250, MARIE);
		repository2 = new ReactiveUserRepository(MIKE);
		mono = part08OtherOperations.useFastestMono(repository1.findFirst(), repository2.findFirst());
		StepVerifier.create(mono)
				.expectNext(MIKE)
				.verifyComplete();
	}


//========================================================================================

	@Test
	public void fastestFlux() {
		ReactiveRepository<User> repository1 = new ReactiveUserRepository(MARIE, MIKE);
		ReactiveRepository<User> repository2 = new ReactiveUserRepository(250);
		Flux<User> flux = part08OtherOperations.useFastestFlux(repository1.findAll(), repository2.findAll());
		StepVerifier.create(flux)
				.expectNext(MARIE, MIKE)
				.verifyComplete();

		repository1 = new ReactiveUserRepository(250, MARIE, MIKE);
		repository2 = new ReactiveUserRepository();
		flux = part08OtherOperations.useFastestFlux(repository1.findAll(), repository2.findAll());
		StepVerifier.create(flux)
				.expectNext(User.SKYLER, User.JESSE, User.WALTER, User.SAUL)
				.verifyComplete();
	}



//========================================================================================

	@Test
	public void complete() {
		ReactiveRepository<User> repository = new ReactiveUserRepository();
		Mono<Void> completion = part08OtherOperations.fluxCompletion(repository.findAll());
		StepVerifier.create(completion)
				.verifyComplete();
	}

//========================================================================================

	@Test
	public void nullHandling() {
		Mono<User> mono = part08OtherOperations.nullAwareUserToMono(User.SKYLER);
		StepVerifier.create(mono)
				.expectNext(User.SKYLER)
				.verifyComplete();
		mono = part08OtherOperations.nullAwareUserToMono(null);
		StepVerifier.create(mono)
				.verifyComplete();
	}

	//========================================================================================

	@Test
	public void emptyHandling() {
		Mono<User> mono = part08OtherOperations.emptyToSkyler(Mono.just(User.WALTER));
		StepVerifier.create(mono)
				.expectNext(User.WALTER)
				.verifyComplete();
		mono = part08OtherOperations.emptyToSkyler(Mono.empty());
		StepVerifier.create(mono)
				.expectNext(User.SKYLER)
				.verifyComplete();
	}


}
