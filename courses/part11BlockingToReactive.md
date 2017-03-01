# Blocking to Reactive

The big question is "How to deal with legacy, non reactive code?"
You have a jdbc database, and you try to avoid to have a too big impact on your performances.
In this kind of situation you can use fromIterable method, but be careful to
call it in a different thread pull. The suscribeOn method, with the elastic scheduler allow
you to do that. But you have to use Flux.defer to precise to reactor to execute the Flux.fromIterable
on this new thread pull.
@[Slow publisher]({"stubs": ["/src/test/java/io/pivotal/literx/Part11BlockingToReactive.java"], "command": "io.pivotal.literx.Part11BlockingToReactiveTest#slowPublisherFastSubscriber", "layout":"aside"})

The last functionality we will see, is the case of a slow subscriber, like in the case of a save.
In this case, you can use the publish on operation, with a parallel scheduler.
Then call doOnNext to the save operation. And call then at the end, to specify the operation is over.
@[Slow subscriber]({"stubs": ["/src/test/java/io/pivotal/literx/Part11BlockingToReactive.java"], "command": "io.pivotal.literx.Part11BlockingToReactiveTest#fastPublisherSlowSubscriber", "layout":"aside"})

