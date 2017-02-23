# Merge

On this first exercise we will just merge elements of the two flux as soon as they arrive.
@[Simple Merge]({"stubs": ["/src/test/java/io/pivotal/literx/Part05Merge.java"], "command": "io.pivotal.literx.Part05MergeTest#mergeWithInterleave", "layout":"aside"})

Be if we want to keep the order of data, we will use concat operator.
Even if the order is maintained, the two flux are rode in the same time. It's the inner logic of concat who reorder anyting.
@[Keep the order]({"stubs": ["/src/test/java/io/pivotal/literx/Part05Merge.java"], "command": "io.pivotal.literx.Part05MergeTest#mergeWithNoInterleave", "layout":"aside"})

Concat operator take publishers on parameters, so if you want to create a flux from monos, keeping the order, you can use it.
@[Create a flux from two mono]({"stubs": ["/src/test/java/io/pivotal/literx/Part05Merge.java"], "command": "io.pivotal.literx.Part05MergeTest#multipleMonoToFlux", "layout":"aside"})

