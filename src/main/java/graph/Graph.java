package graph;

import linkedlist.Bag;

/**
 * An implementation of graph.
 */
public class Graph {
    private final int nVertex;//顶点数目
    private int nEdge;//边的数目
    private Bag<Integer>[] adj;//邻接表数组

    @SuppressWarnings("unchecked")
    public Graph(int nVertex) {
        this.nVertex = nVertex;
        this.nEdge = 0;
        adj = new Bag[nVertex];
        for (int i = 0; i < nVertex; i++)
            adj[i] = new Bag<>();
    }

    public int nVertex() {
        return nVertex;
    }

    public int nEdge() {
        return nEdge;
    }

    public void addEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
        nEdge++;
    }

    public void deleteEdge(int v1, int v2) {
        adj[v1].delete(v2);
        adj[v2].delete(v1);
        nEdge--;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
