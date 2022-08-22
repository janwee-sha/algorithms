# 1. Data structure

## 1.1 Heap

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap/README.markdown)

A heap is a binary tree inside an array,so it does not use parent/child pointers.A heap is sorted based on the "heap property" that determines the order of the nodes in the tree.

Common use for heap：

- To build priority queues.
- To support heap sorts.
- To compute the minumum (or maximum) element of a collection quickly.

### 1.1.1 The heap property

There are two kinds of heaps: a max-heap and a min-heap. In a max-heap parent nodes have a greater value than each of their children. The property of a min-heap is the oppsite. 

> Note：The root of the heap has the maximum or minimum element, but the sort order of other elements are not predictable. For example, the maximum element is always at index 0 in a max-heap, but the minimum element isn’t necessarily the last one. -- the only guarantee you have is that it is one of the leaf nodes, but not which one.

### 1.1.2 The tree inside a array

Implementing a tree-like structure by an array is efficient in both time and space.

There is a well defined relationship between the array index of a tree node and the array indices of its parent and children.

If `i` is the index of a node, then the following formulas give the array indices of its parent and child nodes:

```
parent(i) = floor((i - 1)/2)
left(i) = 2i +1
right(i) = 2i +2
```

### 1.1.3 What can you do with a heap?

There are two primitive operations necessary to make sure the heap is a valid max-heap or min-heap after you insert or remove an element:

- `shiftUp()`:If The element is greater (in max-heap) or smaller than (in min-heap) than its parent, it need to be swapped with the parent. This makes it move up the tree.
- `shiftDown`:If the element is smaller (in max-heap) or greater (in min-heap) than its children, it needs to move down the tree. The operation is also called "heapify".

Shifting up or down is a recursive procedure that takes **O(log n)** time.

Here are other operations that are built on primitive operations:

- `insert(value)`: Adds the new element to the end of the heap and then uses `shiftUp()` to fix the heap.
- `remove()`:Removes and returns the maximum value (max-heap) or the minimum value (min-heap).

### 1.1.4 Implementation

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/heap/Heap.java) is my implementation of Heap.

## 1.2 Binary Search Tree

> The following statement is a quote from [Introduction to Algorithms](https://en.wikipedia.org/wiki/Introduction_to_Algorithms).

Serach trees are data structure that support many dynamic-set operations, including SEARCH, MINIMUM, MAXIMUM, PREDECESSOR, SUCCESSOR, INSERT and DELETE. Thus, a search tree can be used both as a dictionary and as a priority queue.

Basic operations on a binary search tree take time proportional to the height of the tree. For a complete binary tree with `n` nodes, such operations run in `O(log n)` worst-case time. If the tree is a linar chain of `n` nodes, however, the same oeprations take `O(n)` worst-case time.

### 1.2.1 What is a binary search tree?

A binary search tree is organized, as the name suggeests, in a binary tree. Such a tree can be represented by a linked data structure in which each node is an object. In additional to a `key` field and satellite data, each node contains fields `left`, `right` and `p` that point to the nodes corresponding to its left child, its right child, and its parent, respectively. If a child or the parent is missing, the appropriate field contains the value `NIL`.

For any node `x`, the keys in the left subtree of `x` are at most `key[x]`, and the keys in the right subtree of `x` are at least `key[x]`.

### 1.2.2 Querying a binary search tree

A common operation performed on a binary search tree is searching for a key stored in the tree. Besides SEARCH operation, BST can support such queries as MAXIMUM, MINIMUM, SUCCESOR, and PREDECESSOR. Each can be suported in time `O(h)` on a binary search tree of height `h`.

### 1.2.3 Insertion and deletion

The operations of insertion and deletion cause the dynamic set represented by a binary search tree to change. The data structure must be modified to reflect this change, but in such a way that the BST property continues to hold.

### 1.2.4 Implementation

Check my implementation of binary search tree in Java [here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/tree/BST.java).

## 1.3 Red-Black Trees

Red-black trees are one of many search tree schmes that are "balanced" in order to guarantee that the basic dynamic-set operations takes `O(lg n)` time in the worst case.

### 1.3.1 Properties of red-black trees

a **red-black tree** is a binary search tree with one extra bit of storage per node: its **color**, which can be either RED or BLACK.

A binary search tree is a red-black tree if it satisfies the following **red-black properties**:

- Every node is either red or black.
- The root is black.
- Every leaf (NIL) is black.
- If a node is red, then both its child are black.
- For each node, all paths from the node to descendant leaves contains the same number of black nodes.

# 2.Sorting

## 2.1 Bucket sort

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

## 2.2 Heap Sort

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

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap%20Sort/README.markdown) and [https://zhuanlan.zhihu.com/p/269871839](https://zhuanlan.zhihu.com/p/269871839)

### 2.3.1 Introduction

Quicksort is one of the most famous algorithms in history. It was invented way back in 1959 by Tony Hoare, at a time when recursion was still a fairly nebulous concept.

Here's how it works. When given an array, the algorithm splits it up into three parts on "pivot" variable. The pivot can be any element of the sorting part of the array. 

All the elements less than the pivot go into a partition. All the elements equal to or greater than the pivot go into another partition. 

Once we finish to partition, we recursively sort the partitions, then glues those sorted subarrays to get the final result.

### 2.3.2 Implementation

To implement a Quick Sort, we need to consider how to manage the partitions, and put the elements to their correct positions. We can use 4 variables, which can be called `p`,`i`,`j`,`r`. `p` and `r` always mark the start and end position of current subarray. `j` always points at the element to traverse. And `i` marks the end position of the left partition that contains small element. Each time we add an element to the left position, we only need to swap the element `j` and the element `i+1`, then make `i` plus 1. That can help us to achieve the goal of expanding the left partition and the moving the right partition forwards. And when we want to add an element to the right partition, we simply make `j` plus 1. 

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/sort/QuickSort.java) is my implementation of Quick Sort.

# 3. Classic Cases

## 3.1 K-th Largest Element Problem

Given an integer array `a`. Write an algorithm that finds the k-th largest element in the array.

Here's a solution:

> 作者：LeetCode-Solution
> 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
> 来源：力扣（LeetCode）

我们可以用快速排序来解决这个问题，先对原数组排序，再返回倒数第 `k` 个位置，这样平均时间复杂度是 `O(n log n)`O，但其实我们可以做的更快。

首先我们来回顾一下快速排序，这是一个典型的分治算法。我们对数组 `a[l⋯r]` 做快速排序的过程是（参考《算法导论》）：

- 分解： 将数组 `a[l⋯r]`「划分」成两个子数组 `a[1...q-1]`、`a[q+1...r]`，使得`a[1...q-1]`中的元素小于等于`a[q]`，且 `a[q]`小于等于 `a[q+1⋯r]` 中的每个元素。其中，计算下标 `q` 也是「划分」过程的一部分。
- 解决： 通过递归调用快速排序，对子数组 `a[l⋯q−1]` 和`a[q+1⋯r] `进行排序。
- 合并： 因为子数组都是原址排序的，所以不需要进行合并操作，`a[l⋯r]` 已经有序。
上文中提到的 「划分」 过程是：从子数组 `a[l⋯r]` 中选择任意一个元素 `x` 作为主元，调整子数组的元素使得左边的元素都小于等于它，右边的元素都大于等于它， `x` 的最终位置就是 `q`。
由此可以发现每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 `x` 的最终位置为 qq，并且保证 `a[l⋯q−1]` 中的每个元素小于等于 `a[q]`，且 `a[q]` 小于等于 `a[q+1⋯r]` 中的每个元素。所以只要某次划分的 `q` 为倒数第 `k` 个下标的时候，我们就已经找到了答案。 我们只关心这一点，至于 `a[l⋯q−1]` 和 `a[q+1⋯r] `是否是有序的，我们不关心。

因此我们可以改进快速排序算法来解决这个问题：在分解的过程当中，我们会对子数组进行划分，如果划分得到的 `q` 正好就是我们需要的下标，就直接返回 `a[q]`；否则，如果 `q` 比目标下标小，就递归右子区间，否则递归左子区间。这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。

我们知道快速排序的性能和「划分」出的子数组的长度密切相关。直观地理解如果每次规模为 `n` 的问题我们都划分成 1 和 `n−1`，每次递归的时候又向 `n−1` 的集合中递归，这种情况是最坏的，时间代价是 `O(n^2`
 )。我们可以引入随机化来加速这个过程，它的时间代价的期望是`O(n)`，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。

[这里](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/cases/KthLargestElement.java) 是按以上思路实现的代码。