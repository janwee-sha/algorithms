# Binary Search Tree

> The following content is a quote from [Introduction to Algorithms](https://en.wikipedia.org/wiki/Introduction_to_Algorithms) and  [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/kodecocodes/swift-algorithm-club/tree/master/Binary%20Search%20Tree).

Search trees are data structure that support many dynamic-set operations, including SEARCH, MINIMUM, MAXIMUM, PREDECESSOR, SUCCESSOR, INSERT and DELETE. Thus, a search tree can be used both as a dictionary and as a priority queue.

Basic operations on a binary search tree take time proportional to the height of the tree. For a complete binary tree with `n` nodes, such operations run in `O(log n)` worst-case time. If the tree is a linar chain of `n` nodes, however, the same oeprations take `O(n)` worst-case time.

## What is a binary search tree?

A binary search tree is organized, as the name suggests, in a binary tree. Such a tree can be represented by a linked data structure in which each node is an object. In additional to a `key` field and satellite data, each node contains fields `left`, `right` and `p` that point to the nodes corresponding to its left child, its right child, and its parent, respectively. If a child or the parent is missing, the appropriate field contains the value `NIL`.

For any node `x`, the keys in the left subtree of `x` are at most `key[x]`, and the keys in the right subtree of `x` are at least `key[x]`.

## Inserting new nodes

When performing an insertion, we first compare the new value to the root node. If the new value is smaller, we take the left branch; if greater, we take the right branch. We work our way down the tree this way until we find an empty spot where we can insert the new value.

## Searching the tree

A common operation performed on a binary search tree is searching for a key stored in the tree. Besides SEARCH operation, BST can support such queries as MAXIMUM, MINIMUM, SUCCESOR, and PREDECESSOR. Each can be suported in time `O(h)` on a binary search tree of height `h`.

## Iraversing the tree

Sometimes you need to look at all nodes rather than only one.

There are three ways to traverse a binary tree:

1. In-order (or depth-first): First look at the left child of a node then at the node itself and finally at its right child.
2. Pre-order: First look at anode then its left and right children.
3. Post-order: First look at the left and right children and process the node itself last.

## Deleting nodes

Removeing nodes is easy. After removing a node, we replace the node with either its biggest child on the left or its smallest child on the right.That wat the tree is still sorted after the removal.

## Implementation

Check my implementation of binary search tree in Java [here](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/tree/BST.java).