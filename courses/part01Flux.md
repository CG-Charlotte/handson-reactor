# Flux

## Description

A Reactive Streams Publisher with basic flow operators.
- Static factories on Flux allow for source generation from arbitrary callbacks types.
- Instance methods allows operational building, materialized on each _Flux#subscribe()_, _Flux#subscribe()_ or multicasting operations such as _Flux#publish_ and _Flux#publishNext_.

[<img src="https://raw.githubusercontent.com/reactor/projectreactor.io/master/src/main/static/assets/img/marble/flux.png" width="500">](http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)

Flux in action :
```java
Flux.fromIterable(getSomeLongList())
    .mergeWith(Flux.interval(100))
    .doOnNext(serviceA::someObserver)
    .map(d -> d * 2)
    .take(3)
    .onErrorResumeWith(errorHandler::fallback)
    .doAfterTerminate(serviceM::incrementTerminate)
    .subscribe(System.out::println);
```

## Practice 


Let's try a very simple example: just return an empty flux.


```scala
static <T> Flux<T>	empty() Create a Flux that completes without emitting any item.
```
@[Empty flux]({"stubs": ["io/pivotal/literx/Part01Flux.java"], "command": "io.pivotal.literx.Part01FluxTest#empty", "layout":"aside"})



For this exercise method will return

```java
static <T> Flux<T>	just(T... data)
Create a new Flux that emits the specified items and then complete.
```

@[Flux from values]({"stubs": ["io/pivotal/literx/Part01Flux.java"], "command": "io.pivotal.literx.Part01FluxTest#fromValues", "layout":"aside"})


This time we will use items of a list to publish on the flux with from iterable:
```java
static <T> Flux<T> fromIterable(Iterable<? extends T> it)
Create a Flux that emits the items contained in the provided Iterable.
```

@[Create a Flux from a List]({"stubs": ["io/pivotal/literx/Part01Flux.java"], "command": "io.pivotal.literx.Part01FluxTest#fromList", "layout":"aside"})


In a monothread context, it's easy to manage exceptions: throw, catch..
But here we will use flux.error witch is caught in a pipeline.

```java
static <T> Flux<T>	error(Throwable error)
Create a Flux that completes with the specified error.
```

@[Create a Flux that emits an IllegalStateException]({"stubs": ["io/pivotal/literx/Part01Flux.java"], "command": "io.pivotal.literx.Part01FluxTest#error", "layout":"aside"})


To finish with flux, let's try to use a flux who will publish ten time.
In order to do that we will use interval.
But interval is an infinite stream, and we want to take only 10 elements, so don't forget to precise it.

```java
static Flux<Long>	interval(Duration period)
Create a new Flux that emits an ever incrementing long starting with 0 every period on the global timer.
```

@[Create a Flux that emits increasing values]({"stubs": ["io/pivotal/literx/Part01Flux.java"], "command": "io.pivotal.literx.Part01FluxTest#countEach100ms", "layout":"aside"})
