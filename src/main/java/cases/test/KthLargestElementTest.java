package cases.test;

import cases.KthLargestElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementTest {
    private static final int MIN_ELEM_VALUE = (int) Math.pow(-10, 4), MAX_ELEM_VALUE = (int) Math.pow(10, 4);

    @Test
    public void test() {
        KthLargestElement solution = new KthLargestElement();
//        assertEquals(1, solution.kthLargestElement(new int[]{1}, 1));
//        assertEquals(MIN_ELEM_VALUE, solution.kthLargestElement(new int[]{MAX_ELEM_VALUE, MIN_ELEM_VALUE}, 2));
//        assertEquals(MAX_ELEM_VALUE, solution.kthLargestElement(new int[]{-300, 49, MAX_ELEM_VALUE, MAX_ELEM_VALUE, 22, 0, -1},
//                2));
        assertEquals(3, solution.kthLargestElement(new int[]{1, 1, 2, 2, 3, 3, 5, 7, 9, 10}, 5));
    }
}
