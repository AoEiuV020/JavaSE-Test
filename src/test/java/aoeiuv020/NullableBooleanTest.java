package aoeiuv020;

import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AoEiuV020 on 2017/09/20.
 */
public class NullableBooleanTest {
    @Test
    public void testBoolean() {
        Boolean b = null;
        try {
            int a = b ? 1 : 2;
            fail();
        } catch (NullPointerException e) {
        }
    }
}

