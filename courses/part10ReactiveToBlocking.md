# Reactive to Blocking

If you want the value of a mono is really simple: just call block method.
You should  avoid it in production, it kills your reactive pipeline.
@[Value from Mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part10ReactiveToBlocking.java"], "command": "io.pivotal.literx.Part10ReactiveToBlockingTest#monoToValue", "layout":"aside"})

On the same way, you can transform a flux to an iterable, with to iterable.
@[Flux to iterable]({"stubs": ["/src/test/java/io/pivotal/literx/Part10ReactiveToBlocking.java"], "command": "io.pivotal.literx.Part10ReactiveToBlockingTest#fluxToValues", "layout":"aside"})
