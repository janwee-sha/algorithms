package Graph;

import java.util.Stack;

public interface Search {
    boolean hasPathTo(int target);

    Stack<Integer> pathTo(int target);
}
