package aoeiuv020;

import java.util.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by AoEiuV020 on 2017/07/04.
 */
public class Try {
    int i = 0;
    @Before
    public void setUp() {
        try {
            return;
        } finally {
            i = 1;
        }
    }
    @Test
    public void tryFinally() {
        assertEquals(1, i);
    }
}

