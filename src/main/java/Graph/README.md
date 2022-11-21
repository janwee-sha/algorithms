# Graph

> The following content is a reference to [Robert Sedgewick and Kevin Wayne's Algorithms, 4th Edition](https://sedgewick.io/books/algorithms/).

> 定义: 图是一组顶点和一组能够将两个顶点相连的边组成的。

![image](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/Graph/images/Graph.png)

特殊的图:

- **自环**：即一条连接一个顶点和自身的边
- 连接同一对顶点的两条边称为**平行边**。

![image](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/Graph/images/Anomalies.png)

4种重要的图模型：

- **无向图**：简单连接的图。
- **有向图**：连接有方向性的图。
- **加权图**：连接带有权值的图。
- **加权有向图**：连接既有方向有带有权值的图。

## 无向图

图的几种表示方法：

- **邻接矩阵**。使用一个`V`乘以`V`的布尔矩阵。当顶点`v`和顶点`w`之间有相连接的边时，定义v行w列的元素值为`true`，否则为`false`。
- **边的数组**。使用一个`Edge`类，它含有两个`int`实例变量。
- **邻接表数组**。使用一个以顶点为索引的列表数组，其中的每个元素都适合该顶点相邻的顶点列表。

![image](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/Graph/images/AdjListsRepresentation.png)

[这里](https://github.com/janwee-sha/algorithms/blob/main/src/main/java/Graph/Graph.java)是用邻接表数组的表示方式实现的图的代码。