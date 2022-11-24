# Bucket Sort
> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Bucket%20Sort/README.markdown)

Bucket sort,also known as Bin Sort,is a distributed sorting algorithm,which sort elements from an array by performing these steps:

1.  Distribute the elements into buckets or bins.
2.  Sort each bucket individually.
3.  Merge the buckets in order to produce a sorted array as the result.

The performance for execution time is:

| Case    | Performance |
| ------- | ----------- |
| Worst   | O(n^2)      |
| Best    | Omega(n+k)  |
| Average | Theta(n+k)  |

> Note: **N** is the number of elements and **K** is the number of buckets.

In the best case, the algorithm distributes the elements uniformly between buckets, a few elements are placed on each bucket and sorting the buckets is O(1). Rearranging the elements is one more run through the initial list.

In the worst case, the elements are sent all to the same bucket, making the process take O(n^2).

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/BucketSort/BucketSort.java) is my implementation of Bucket Sort.