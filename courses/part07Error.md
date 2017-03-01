# Error

Let's see how to deal with errors

In this first example, we will return a Mono containing user Saul when an error occur, with the method
otherwise. In order to to this, transform the exception in User.Saul!
@[Otherwise]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#monoWithValueInsteadOfError", "layout":"aside"})


Let's try the same thing with flux. In this case, we call onErrorResumeWith.
We will use the same kind of transformation, but with Saul and Jesse.
This method allows you, if a flux doesn't work to switch to another publisher.
@[OnErrorResumeWith on flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#fluxWithValueInsteadOfError", "layout":"aside"})


The checked exceptions are not always easy to use with lambdas.
In this case, in the method capitalize many, as GetOutOfHereException is checked
the call should be surround with try/catch and for example wrap it in a runtimeException
to be catched in the expectError. But in this case you will catch the wrapper
and not the GetOutOfHereException.
Instead you can use exception.propagate, who create a specific wrapper, who is automatically
unwrapped in the expect error.


@[Checked exception]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#handleCheckedExceptions", "layout":"aside"})

