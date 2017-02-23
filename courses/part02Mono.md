# Mono

## Description

A Mono is a Reactive Streams Publisher with basic rx operators that completes successfully by emitting an element, or with an error.

[<img src="https://raw.githubusercontent.com/reactor/reactor-core/v3.0.5.RELEASE/src/docs/marble/mono.png" width="500">](http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)

So let's try it.

## Practice 


As for the flux let's return a empty mono from the static method.


```java
static <T> Mono<T>	empty()
Create a Mono that completes without emitting any item.
```
@[Empty Mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part02Mono.java"], "command": "io.pivotal.literx.Part02MonoTest#empty", "layout":"aside"})



Now, we will try to create a mono who never emit anything.
Unlike empty() who emit a complete event this one will not.

@[No Emission]({"stubs": ["/src/test/java/io/pivotal/literx/Part02Mono.java"], "command": "io.pivotal.literx.Part02MonoTest#noSignal", "layout":"aside"})


Now, you can create a mono from an unique value.

@[Create a Mono from an item]({"stubs": ["/src/test/java/io/pivotal/literx/Part02Mono.java"], "command": "io.pivotal.literx.Part02MonoTest#fromValue", "layout":"aside"})


And exactly as we did for the flux, we can manage exceptions.


@[Create a Mono that emits an IllegalStateException]({"stubs": ["/src/test/java/io/pivotal/literx/Part02Mono.java"], "command": "io.pivotal.literx.Part02MonoTest#error", "layout":"aside"})


