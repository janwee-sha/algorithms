# Heap Sort

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap%20Sort/README.markdown)

Sorts an array from low to high using a heap.

To sort from lowest to highest, heap sort first converts the unsorted array to a max-heap, so that the first element in the array is the largest.

Let's say the array to sort is:

    [5,13,2,25,7,17,20,8,4]

This is first turned into a max-heap that looks like this:

    [25,13,20,8,7,17,2,5,4]

And then we swap the first element (index `0`) with the last one at index `n-1`, to get:

    [4,13,20,8,7,17,2,5,25]
     *                   *

Now the new root is `4`, will be smaller than its children, so we fix up the max-heap to element `n-2` using the shift down or "heapify" procedure. After that, we get:

    [20,13,17,8,7,4,2,5 | 25]

Again, we swap the first element with the last one (this time at index `n-2`):

    [5,13,17,8,7,4,2,20 | 25]
     *               *

And fix up the heap again:

    [17,13,5,8,7,4,2 | 20,25]

We repeat this process until we arrive at the root node and then the whole array is sorted.

Performance of heap sort is **O(n log n)** in best, worst, and average case.

**Implementation**:

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/heapsort/HeapSort.java) is my implementation of Heap Sort.