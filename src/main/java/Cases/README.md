# Cases

## K-th Largest Element Problem

Given an integer array `a`. Write an algorithm that finds the k-th largest element in the array.

Here's a solution:

> 作者：LeetCode-Solution
> 链接：<https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/>
> 来源：力扣（LeetCode）

我们可以用快速排序来解决这个问题，先对原数组排序，再返回倒数第 `k` 个位置，这样平均时间复杂度是 `O(n log n)`O，但其实我们可以做的更快。

首先我们来回顾一下快速排序，这是一个典型的分治算法。我们对数组 `a[l⋯r]` 做快速排序的过程是（参考《算法导论》）：

*   分解： 将数组 `a[l⋯r]`「划分」成两个子数组 `a[1...q-1]`、`a[q+1...r]`，使得`a[1...q-1]`中的元素小于等于`a[q]`，且 `a[q]`小于等于 `a[q+1⋯r]` 中的每个元素。其中，计算下标 `q` 也是「划分」过程的一部分。
*   解决： 通过递归调用快速排序，对子数组 `a[l⋯q−1]` 和`a[q+1⋯r] `进行排序。
*   合并： 因为子数组都是原址排序的，所以不需要进行合并操作，`a[l⋯r]` 已经有序。
    上文中提到的 「划分」 过程是：从子数组 `a[l⋯r]` 中选择任意一个元素 `x` 作为主元，调整子数组的元素使得左边的元素都小于等于它，右边的元素都大于等于它， `x` 的最终位置就是 `q`。
    由此可以发现每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 `x` 的最终位置为 qq，并且保证 `a[l⋯q−1]` 中的每个元素小于等于 `a[q]`，且 `a[q]` 小于等于 `a[q+1⋯r]` 中的每个元素。所以只要某次划分的 `q` 为倒数第 `k` 个下标的时候，我们就已经找到了答案。 我们只关心这一点，至于 `a[l⋯q−1]` 和 `a[q+1⋯r] `是否是有序的，我们不关心。

因此我们可以改进快速排序算法来解决这个问题：在分解的过程当中，我们会对子数组进行划分，如果划分得到的 `q` 正好就是我们需要的下标，就直接返回 `a[q]`；否则，如果 `q` 比目标下标小，就递归右子区间，否则递归左子区间。这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。

我们知道快速排序的性能和「划分」出的子数组的长度密切相关。直观地理解如果每次规模为 `n` 的问题我们都划分成 1 和 `n−1`，每次递归的时候又向 `n−1` 的集合中递归，这种情况是最坏的，时间代价是 `O(n^2`
)。我们可以引入随机化来加速这个过程，它的时间代价的期望是`O(n)`，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。

[这里](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/cases/KthLargestElement.java) 是按以上思路实现的代码。