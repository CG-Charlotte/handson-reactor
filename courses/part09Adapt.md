# Adapt

You can transfer from rxJava2 to reactor 3 without a single external library.

In this first example we will adapt from flux to flowable observable, wich implement publisher
with Flowable.fromPublisher
and in the second exercise, we will do the opposite with Flux.from.
@[Flowable from flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToFlowable", "layout":"aside"})
@[Flux from flowable]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToObservable", "layout":"aside"})


Now, more difficult: we will adapt from flux to a observable wh ich doesn't implement publisher.
In the first case, you can transform the publisher to observable.
In the second case, you have to use a buffer, helped by the toFlowable function.
@[Flux to observable]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToObservable", "layout":"aside"})
@[Observable to flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToObservable", "layout":"aside"})

Let's try to transform a mono to a rxJava single. You can just call the firstOrError method
from observable. For the other way, you can use a single.toFlowable.
@[Mono to java single]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToSingle", "layout":"aside"})
@[Java single to mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToSingle", "layout":"aside"})

To conclude, you can easily transform to CompletableFuture with toFuture method
and the opposite with from future.
@[Mono to Completable Future]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToSingle", "layout":"aside"})
@[Completable future to mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part09Adapt.java"], "command": "io.pivotal.literx.Part09AdaptTest#adaptToCompletableFuture", "layout":"aside"})
