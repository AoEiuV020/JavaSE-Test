package aoeiuv020;

import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AoEiuV020 on 2017/06/10.
 */
public class OperatorTest {
    @Test
    public void andAssign() throws Exception {
        boolean b = false;
        Wrapper w = new Wrapper();
        assertEquals(0, w.n);
        b &= w.inc();
        assertEquals(false, b);
        assertEquals(1, w.n);
        b = true;
        b &= w.inc();
        assertEquals(true, b);
        assertEquals(2, w.n);
        b &= w.dec();
        assertEquals(false, b);
        assertEquals(1, w.n);
    }
    class Wrapper {
        int n = 0;
        boolean inc() {
            ++n;
            return true;
        }
        boolean dec() {
            --n;
            return false;
        }
    }
}

