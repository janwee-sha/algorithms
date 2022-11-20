package Graph;

import java.util.Stack;

//find a path from one vertex to another using depth first search
public class DepthFirstGraphPaths implements GraphPaths {
    private final int sVertex;//first vertex
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstGraphPaths(Graph graph, int sVertex) {
        this.marked = new boolean[graph.nVertex()];
        this.edgeTo = new int[graph.nVertex()];
        this.sVertex = sVertex;
        dfs(graph, sVertex);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int v : graph.adj(vertex))
            if (!marked[v]) {
                edgeTo[v] = vertex;
                dfs(graph, v);
            }
    }


    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Stack<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) return null;
        Stack<Integer> path = new Stack<>();
        for (int v = vertex; v != sVertex; v = edgeTo[v]) path.push(v);
        path.push(sVertex);
        return path;
    }
}