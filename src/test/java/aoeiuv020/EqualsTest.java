package aoeiuv020;

import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 反人类的==，这种奇怪的坑绕开就行，就不改使用，
 * 默认是小于等于127的都指向常量所以相等，
 * new出来的不指向常量，
 * 基本类型和包装类型==是自动拆箱，
 * Created by AoEiuV020 on 2017/05/16.
 */
public class EqualsTest {
    @Test
    public void equals() throws Exception {
        Long l1 = new Long(127L);
        Long l2 = new Long(127L);
        Long l3 = 127L;
        Long l4 = 127L;
        Long l5 = 128L;
        Long l6 = 128L;
        assertFalse(l1 == l2);
        assertTrue(l3 == l4);
        assertFalse(l5 == l6);
        assertFalse(new Long(127L) == new Long(127L));
        assertFalse(new Long(128L) == new Long(128L));
        assertTrue(128L == new Long(128L));
    }
}

