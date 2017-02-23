# Transform

## Description
Let's try to do some transformations on our datas

## Practice 

In the first place, we will capitalize string. For this we will just map with a lambda, on the synchronous way.
As the mapping expect no latency, we can use it.
@[Capitalize data on Mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part04Transform.java"], "command": "io.pivotal.literx.Part04TransformTest#transformMono", "layout":"aside"})

So we can use exactly the same code on a flux.
@[Capitalize data on Flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part04Transform.java"], "command": "io.pivotal.literx.Part04TransformTest#transformFlux", "layout":"aside"})

Now imagine that we have to call a webservice to capitalize our data. This new call can cause latency.
We cannot use the synchronous map anymore.
We will use an asynchronous flatmap that transform the items emitted by this flux into Publishers,
then flatten the emissions from those by merging them into a single flux so that they may interleave.

<img class="marble" src="https://raw.githubusercontent.com/reactor/projectreactor.io/master/src/main/static/assets/img/marble/flatmap.png" alt="">


@[Async transformation]({"stubs": ["/src/test/java/io/pivotal/literx/Part04Transform.java"], "command": "io.pivotal.literx.Part04TransformTest#asyncTransformFlux", "layout":"aside"})

