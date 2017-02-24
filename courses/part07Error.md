# Error

Let's see how to deal with errors

In this first example, we will return a Mono containing user Saul when an error occur, with the method
otherwise. In order to to this, transform the exeption in User.Saul!
@[Otherwise]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#monoWithValueInsteadOfError", "layout":"aside"})


Let's try the same thing with flux. In this case, we call onErrorResumeWith.
We will use the same kind of transformation, but with Saul and Jesse.
This method allows you, if a flux doesn't work to switch to another publisher.
@[OnErrorResumeWith on flux]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#fluxWithValueInsteadOfError", "layout":"aside"})


The checked exeption are not always easy to use with lambdas
@[Checked exception]({"stubs": ["/src/test/java/io/pivotal/literx/Part07Errors.java"], "command": "io.pivotal.literx.Part07ErrorsTest#handleCheckedExceptions", "layout":"aside"})

