# 1.Sorting algorithms

## 1.1 Bucket sort

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Bucket%20Sort/README.markdown)

Bucket sort,also known as Bin Sort,is a distributed sorting algorithm,which sort elements from an array by performing these steps:

1. Distribute the elements into buckets or bins.
2. Sort each bucket individually.
3. Merge the buckets in order to produce a sorted array as the result.

The performance for execution time is:


| Case | Performance |
| --- | --- |
| Worst | O(n^2) |
| Best | Omega(n+k) |
| Average | Theta(n+k) |

> Note: **N** is the number of elements and **K** is the number of buckets.

In the best case, the algorithm distributes the elements uniformly between buckets, a few elements are placed on each bucket and sorting the buckets is O(1). Rearranging the elements is one more run through the initial list.

In the worst case, the elements are sent all to the same bucket, making the process take O(n^2).

## 1.2 Heap Sort

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap%20Sort/README.markdown)

Sorts an array from low to high using a heap. 

To sort from lowest to highest, heap sort first converts the unsorted array to a max-heap, so that the first element in the array is the largest.

Let's say the array to sort is:


```
[5,13,2,25,7,17,20,8,4]
```

This is first turned into a max-heap that looks like this:

```
[25,13,20,8,7,17,2,5,4]
```

And then we swap the first element (index `0`) with the last one at index `n-1`, to get:

```
[4,13,20,8,7,17,2,5,25]
 *                   *
```

Now the new root is `4`, will be smaller than its children, so we fix up the max-heap to element `n-2` using the shift down or "heapify" procedure. After that, we get:

```
[20,13,17,8,7,4,2,5 | 25]
```

Again, we swap the first element with the last one (this time at index `n-2`):

```
[5,13,17,8,7,4,2,20 | 25]
 *               *
```

And fix up the heap again:

```
[17,13,5,8,7,4,2 | 20,25]
```

We repeat this process until we arrive at the root node and then the whole array is sorted.

Performance of heap sort is **O(n log n)** in best, worst, and average case.

**Implementation**:

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/sort/HeapSort.java) is my implementation of Heap Sort.

## 2.3 Quicksort

### 2.3.1 Introduction

Quicksort is one of the most famous algorithms in history. It was invented way back in 1959 by Tony Hoare, at a time when recursion was still a fairly nebulous concept.

Here's how it works. When given an array, the algorithm splits it up into three parts on "pivot" variable. The pivot can be any element of the sorting part of the array. 

All the elements less than the pivot go into a partition. All the elements equal to or greater than the pivot go into another partition. 

Once we finish to partition, we recursively sort the partitions, then glues those sorted subarrays to get the final result.

### 2.3.2 Implementation

To implement a Quick Sort, we need to consider how to manage the partitions, and put the elements to their correct positions. We can use 4 variables, which can be called `p`,`i`,`j`,`r`. `p` and `r` always mark the start and end position of current subarray. `j` always points at the element to traverse. And `i` marks the end position of the left partition that contains small element. Each time we add an element to the left position, we only need to swap the element `j` and the element `i+1`, then make `i` plus 1. That can help us to achieve the goal of expanding the left partition and the moving the right partition forwards. And when we want to add an element to the right partition, we simply make `j` plus 1. 

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/sort/QuickSort.java) is my implementation of Quick Sort.


# 2. Data structure

## 2.1 Heap

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap/README.markdown)

A heap is a binary tree inside an array,so it does not use parent/child pointers.A heap is sorted based on the "heap property" that determines the order of the nodes in the tree.

Common use for heap：

- To build priority queues.
- To support heap sorts.
- To compute the minumum (or maximum) element of a collection quickly.

### 2.1.1 The heap property

There are two kinds of heaps: a max-heap and a min-heap. In a max-heap parent nodes have a greater value than each of their children. The property of a min-heap is the oppsite. 

> Note：The root of the heap has the maximum or minimum element, but the sort order of other elements are not predictable. For example, the maximum element is always at index 0 in a max-heap, but the minimum element isn’t necessarily the last one. -- the only guarantee you have is that it is one of the leaf nodes, but not which one.

### 2.1.2 The tree inside a array

Implementing a tree-like structure by an array is efficient in both time and space.

There is a well defined relationship between the array index of a tree node and the array indices of its parent and children.

If `i` is the index of a node, then the following formulas give the array indices of its parent and child nodes:

```
parent(i) = floor((i - 1)/2)
left(i) = 2i +1
right(i) = 2i +2
```

### 2.1.3 What can you do with a heap?

There are two primitive operations necessary to make sure the heap is a valid max-heap or min-heap after you insert or remove an element:

- `shiftUp()`:If The element is greater (in max-heap) or smaller than (in min-heap) than its parent, it need to be swapped with the parent. This makes it move up the tree.
- `shiftDown`:If the element is smaller (in max-heap) or greater (in min-heap) than its children, it needs to move down the tree. The operation is also called "heapify".

Shifting up or down is a recursive procedure that takes **O(log n)** time.

Here are other operations that are built on primitive operations:

- `insert(value)`: Adds the new element to the end of the heap and then uses `shiftUp()` to fix the heap.
- `remove()`:Removes and returns the maximum value (max-heap) or the minimum value (min-heap).

### 2.1.4 Implementation

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/heap/Heap.java) is my implementation of Heap.

# 3. Classic Cases

## 3.1 K-th Largest Element Problem

Given an integer array `a`. Write an algorithm that finds the k-th largest element in the array.