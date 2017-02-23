# StepVerifier

## Description

Until here, for each exercise we did, publisher was checked in in the unit tests by a stepverifier.
It will verify that data are well emitted.
We now will see how it works.

As usual, you can obtain an instance of StepVerifier from a static method create.
This on take any kind of publisher on parameter, as a flux as an Akka Stream.

StepVerifier is always built as follow:
```Java
StepVerifier.create(T<Publisher>).{expectations...}.verify()
```

## Practice 


We will verify the two next elements emits by a flux, and that this one well terminate.

@[Verify Simple flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part03StepVerifier.java"], "command": "io.pivotal.literx.Part03StepVerifierTest#expectElementsThenComplete", "layout":"aside"})

Now, let's do the same test but an exception is thrown at the end.

@[Verify an error]({"stubs": ["/src/test/java/io/pivotal/literx/Part03StepVerifier.java"], "command": "io.pivotal.literx.Part03StepVerifierTest#expect2ElementsThenError", "layout":"aside"})


Try to create a stepVerifier, that take a lambda in parameters. This one must return true when the predicate is verified.
You can too use a assertion from an assertion library.

@[Lambda and assertion]({"stubs": ["/src/test/java/io/pivotal/literx/Part03StepVerifier.java"], "command": "io.pivotal.literx.Part03StepVerifierTest#expectElementsWithThenComplete", "layout":"aside"})


On this test we will use a flux who take some time to emit.
As expected, the test will take some time to run.
In the real world publisher will take some time to answer.

@[Wait some time]({"stubs": ["/src/test/java/io/pivotal/literx/Part03StepVerifier.java"], "command": "io.pivotal.literx.Part03StepVerifierTest#count", "layout":"aside"})

With reactor you can accelerate virtual time, in way to test slow publisher.
```Java
StepVerifier.withVirtualtime(supplier).await(Duration.time)
```
@[time travelling]({"stubs": ["/src/test/java/io/pivotal/literx/Part03StepVerifier.java"], "command": "io.pivotal.literx.Part03StepVerifierTest#countWithVirtualTime", "layout":"aside"})


