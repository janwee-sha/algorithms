# Quicksort

> The following statement is a quote from [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/raywenderlich/swift-algorithm-club/blob/master/Heap%20Sort/README.markdown) and <https://zhuanlan.zhihu.com/p/269871839>

### 2.3.1 Introduction

Quicksort is one of the most famous algorithms in history. It was invented way back in 1959 by Tony Hoare, at a time when recursion was still a fairly nebulous concept.

Here's how it works. When given an array, the algorithm splits it up into three parts on "pivot" variable. The pivot can be any element of the sorting part of the array.

All the elements less than the pivot go into a partition. All the elements equal to or greater than the pivot go into another partition.

Once we finish to partition, we recursively sort the partitions, then glues those sorted subarrays to get the final result.

### 2.3.2 Implementation

To implement a Quick Sort, we need to consider how to manage the partitions, and put the elements to their correct positions. We can use 4 variables, which can be called `p`,`i`,`j`,`r`. `p` and `r` always mark the start and end position of current subarray. `j` always points at the element to traverse. And `i` marks the end position of the left partition that contains small element. Each time we add an element to the left position, we only need to swap the element `j` and the element `i+1`, then make `i` plus 1. That can help us to achieve the goal of expanding the left partition and the moving the right partition forwards. And when we want to add an element to the right partition, we simply make `j` plus 1.

[Here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/quicksort/QuickSort.java) is my implementation of Quick Sort.