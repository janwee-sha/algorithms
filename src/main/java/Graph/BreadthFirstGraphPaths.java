package Graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

//find a path from one vertex to another using breadth first search
public class BreadthFirstGraphPaths implements GraphPaths {
    private final int sVertex;
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstGraphPaths(Graph graph, int sVertex) {
        this.marked = new boolean[graph.nVertex()];
        this.edgeTo = new int[graph.nVertex()];
        this.sVertex = sVertex;
        bfs(graph, sVertex);
    }

    private void bfs(Graph graph, int sVertex) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        marked[sVertex] = true;//标记起点
        queue.add(sVertex);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
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
