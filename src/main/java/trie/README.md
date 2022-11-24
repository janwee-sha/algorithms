# Trie

> The following content is a reference to [https://github.com/raywenderlich/swift-algorithm-club](https://github.com/kodecocodes/swift-algorithm-club/blob/master/Trie/ReadMe.md).

## What is a Trie?

A **Trie**, (AKA a prefix tree, or radix tree in some other implementations) is a special type of tree used to store associative data structures. A **Trie** for a dictionary might look like this:

![image](https://note.youdao.com/favicon.ico)

## Why a Trie?

Tries are very useful for certain siuations. Here are some of the advantages:

- Looking up values typically have a better worst-case time complexity.
- Unlike a hash map, a Trie does not need to worry about key collisions.
- Doesn't utilize hashing to guarantee a unique path to elements.
- Trie structures can be alphabetically ordered by default.

## Common algorithms

### Contains

**Trie** structures are great for lookup operations. For **Trie** structures that model the English language, finding a particular word is a matter of a few pointer traversals.