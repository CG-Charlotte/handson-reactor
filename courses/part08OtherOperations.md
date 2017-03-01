# Other Operations


Here we have 3 String flux, theses elements could arrive with latency, and we want to create a new person
with theses 3 elements. Zip operator concat these 3 flux.
@[Zip Operator]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#zipFirstNameAndLastName", "layout":"aside"})

If you have 3 mono competing, you can use first method to keep the fastest.
@[Fatest Mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#fastestMono", "layout":"aside"})

For flux, you will find the same kind of tool called firstEmitting. In this case
it's the flux who emit the first element first which is selected. Flux aren't mixed.
@[First Emiting]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#fastestFlux", "layout":"aside"})

Flux has a then operator, who verify the completion.
@[Flux Completion]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#complete", "layout":"aside"})

Reactive streams does not allow null value. So you can create a valid empty mono
if null is provided, and a real mono otherwise.
@[Null aware user to mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#nullHandling", "layout":"aside"})

You can too return a default value if the stream is empty, with otherwiseIsEmpty.
@[Otherwise if empty]({"stubs": ["/src/test/java/io/pivotal/literx/Part08OtherOperations.java"], "command": "io.pivotal.literx.Part08OtherOperationsTest#emptyHandling", "layout":"aside"})
