package Transform.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Transform.ArabicToChinese;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArabicToChineseTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting ArabicToChineseTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished ArabicToChineseTest.");
    }

    @Test
    public void testArabicToChinese() {
        System.out.println("Testing arabicToChinese.");

        ArabicToChinese instance = new ArabicToChinese();

        assertEquals("二十一亿四千七百四十八万三千六百四十七", instance.arabicToChinese(Integer.MAX_VALUE));
        assertEquals("零", instance.arabicToChinese(0));
        assertEquals("一千零二万三千零四十", instance.arabicToChinese(1002_3040));
    }
}
