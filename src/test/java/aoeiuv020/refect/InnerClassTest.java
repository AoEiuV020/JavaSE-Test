package aoeiuv020.refect;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 内部类的测试,
 * Created by AoEiuV020 on 2017/05/04.
 */
public class InnerClassTest {
    /**
     * 内部类的构造方法有一个隐藏的参数，
     *   public aoeiuv020.refect.InnerClassTest$A(aoeiuv020.refect.InnerClassTest);
     *    descriptor: (Laoeiuv020/refect/InnerClassTest;)V
     */
    @Test
    public void constructor() throws Exception {
        Class<?> a = A.class;
        try {
            a.getDeclaredConstructor();
            fail();
        } catch (NoSuchMethodException e) {
        }
        a.getDeclaredConstructor(InnerClassTest.class);
    }

    class A {
        public A() {
        }
    }
}

