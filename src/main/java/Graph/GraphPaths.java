package Graph;

import java.util.Stack;

public interface GraphPaths {
    boolean hasPathTo(int target);

    Stack<Integer> pathTo(int target);
}
