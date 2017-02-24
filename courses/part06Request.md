# Request
How to control the demand
Request will help you to control the demmand
Reactive stream allows you to control the demand

This first exemple expect 4 values to be received, before complete.
@[Request All]({"stubs": ["/src/test/java/io/pivotal/literx/Part06Request.java"], "command": "io.pivotal.literx.Part06RequestTest#requestAll", "layout":"aside"})

Now we will expect values one by one: we will specify elements separatly
Step verifier help you to verify the values: on the create method you can specify the number of elements you want,
but you can alse have some action who control the reactive streams behaviour.
Don't forget to cancel after the two first elements.
@[Request One By One]({"stubs": ["/src/test/java/io/pivotal/literx/Part06Request.java"], "command": "io.pivotal.literx.Part06RequestTest#requestOneByOne", "layout":"aside"})

It'simpostant to be able to debug reactive API, so in this example we will get
all the users stored in the repository and next get the log to know exactly what happens
in term of signals and events.
You will see in the log below the on subscribe, the on next, the callback...
@[Request Log]({"stubs": ["/src/test/java/io/pivotal/literx/Part06Request.java"], "command": "io.pivotal.literx.Part06RequestTest#experimentWithLog", "layout":"aside"})

If you want to perform custom actions, like print "Starring:" on subscribe
and "firstname, lastname" for all values received, you can use the doOn method.
DoOn method provide you some callback, to customize your actions.
You should not use latency involve operations here: it's more for small, synchronized operations
@[Custom Operations]({"stubs": ["/src/test/java/io/pivotal/literx/Part06Request.java"], "command": "io.pivotal.literx.Part06RequestTest#experimentWithDoOn", "layout":"aside"})


