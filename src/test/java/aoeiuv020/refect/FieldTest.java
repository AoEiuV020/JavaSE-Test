package aoeiuv020.refect;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AoEiuV020 on 2017/05/07.
 */
public class FieldTest {
    @Test
    public void accessible() throws Exception {
        Class<?> c = CA.class;
        Field fS = c.getField("s");
        //这不科学啊，public变量isAccessible居然是false, 但是能get,
        //isAccessible只是返回setAccessible的结果，
        //无法判断原本的可见性，
        assertFalse(fS.isAccessible());
        assertEquals("s", fS.get(null));
        Method mS = c.getMethod("getS");
        assertFalse(mS.isAccessible());
        assertEquals("s", mS.invoke(null));
        fS.setAccessible(true);
        assertTrue(fS.isAccessible());
        assertEquals("s", fS.get(null));
        fS.setAccessible(false);
        assertFalse(fS.isAccessible());
        assertEquals("s", fS.get(null));
    }

    static class CA {
        public static String s = "s";
        public static String getS() {
            return s;
        }
    }
}

