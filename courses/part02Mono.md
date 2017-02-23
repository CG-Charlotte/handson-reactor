# Mono

## Description

A Reactive Streams Publisher constrained to *ZERO* or *ONE* element with appropriate operators. 
- Static factories on Mono allow for deterministic *zero or one* sequence generation from arbitrary callbacks types.
- Instance methods allows operational building, materialized on each _Mono#subscribe()_ or _Mono#get()_ eventually called.

[<img src="https://raw.githubusercontent.com/reactor/projectreactor.io/master/src/main/static/assets/img/marble/mono.png" width="500">](http://projectreactor.io/core/docs/api/reactor/core/publisher/Mono.html)

Mono in action :
```java
Mono.fromCallable(System::currentTimeMillis)
    .then(time -> Mono.first(serviceA.findRecent(time), serviceB.findRecent(time)))
    .timeout(Duration.ofSeconds(3), errorHandler::fallback)
    .doOnSuccess(r -> serviceM.incrementSuccess())
    .subscribe(System.out::println);
```

Blocking Mono result :
```java    
Tuple2<Long, Long> nowAndLater = 
        Mono.when(
                Mono.just(System.currentTimeMillis()),
                Flux.just(1).delay(1).map(i -> System.currentTimeMillis()))
            .block();
```

## Practice 

@[An empty Mono]({"stubs": ["io/pivotal/literx/Part02MonoEmpty.java"], "command": "io.pivotal.literx.Part02Mono#empty"})

@[A Mono that never emit any signal]({"stubs": ["io/pivotal/literx/Part02MonoWithNoSignal.java"], "command": "io.pivotal.literx.Part02Mono#noSignal"})

@[A Mono that contains a "foo" value]({"stubs": ["io/pivotal/literx/Part02MonoFromValue.java"], "command": "io.pivotal.literx.Part02Mono#fromValue"})

@[A Mono that emits an IllegalStateException]({"stubs": ["io/pivotal/literx/Part02MonoError.java"], "command": "io.pivotal.literx.Part02Mono#error"})
