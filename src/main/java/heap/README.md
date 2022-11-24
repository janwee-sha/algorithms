# Heap

> The following content is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap/README.markdown)

A heap is a binary tree inside an array,so it does not use parent/child pointers.A heap is sorted based on the "heap property" that determines the order of the nodes in the tree.

Common use for heap：

*   To build priority queues.
*   To support heap sorts.
*   To compute the minumum (or maximum) element of a collection quickly.

## The heap property

There are two kinds of heaps: a max-heap and a min-heap. In a max-heap parent nodes have a greater value than each of their children. The property of a min-heap is the oppsite.

> Note：The root of the heap has the maximum or minimum element, but the sort order of other elements are not predictable. For example, the maximum element is always at index 0 in a max-heap, but the minimum element isn’t necessarily the last one. -- the only guarantee you have is that it is one of the leaf nodes, but not which one.

## The tree inside a array

Implementing a tree-like structure by an array is efficient in both time and space.

There is a well defined relationship between the array index of a tree node and the array indices of its parent and children.

If `i` is the index of a node, then the following formulas give the array indices of its parent and child nodes:

    parent(i) = floor((i - 1)/2)
    left(i) = 2i +1
    right(i) = 2i +2

Note that this scheme has limitations. You can do the following with a regular binary tree but not with a heap.

![image](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/heap/images/Algorithms.RegularTree.png)

You can not start a new level unless the current lowest level is completely full, so heaps always have this kind of shape.

![image](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/heap/images/Algorithms.HeapShape.png)

## What can you do with a heap?

There are two primitive operations necessary to make sure the heap is a valid max-heap or min-heap after you insert or remove an element:

*   `shiftUp()`:If The element is greater (in max-heap) or smaller than (in min-heap) than its parent, it need to be swapped with the parent. This makes it move up the tree.
*   `shiftDown`:If the element is smaller (in max-heap) or greater (in min-heap) than its children, it needs to move down the tree. The operation is also called "heapify".

Shifting up or down is a recursive procedure that takes **O(log n)** time.

Here are other operations that are built on primitive operations:

*   `insert(value)`: Adds the new element to the end of the heap and then uses `shiftUp()` to fix the heap.
*   `remove()`:Removes and returns the maximum value (max-heap) or the minimum value (min-heap).

## Implementation

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/btree/BTree.java) is my implementation of Heap.