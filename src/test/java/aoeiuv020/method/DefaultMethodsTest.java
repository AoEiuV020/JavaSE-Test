package aoeiuv020.method;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by AoEiuV020 on 2017/04/30.
 */
public class DefaultMethodsTest{
    @Test
    public void defaultMethods() throws Exception {
        CA a = new CA();
        assertEquals(0, a.getInt());
        CB b = new CB();
        assertEquals(b.hashCode(), b.getInt());
        CC c = new CC();
        assertEquals(-c.hashCode(), c.getInt());
        CD d = new CD();
        assertEquals(1, d.getInt());
        //assertEquals(1, CD.getInt(d)); // method getInt in interface IC cannot be applied to given types;
        assertEquals(1, IC.getInt(d));
    }
    static interface IA {
        default int getInt() {
            return hashCode();
        }
    }
    static interface IB {
        default int getInt() {
            return -hashCode();
        }
    }
    static interface IC {
        default int getInt() {
            return 1;
        }
        static int getInt(IC c){
            return c.getInt();
        }
    }
    static class CA implements IA, IB {
        //多重继承，二义，必需重写，否则，
        //class CA inherits unrelated defaults for getInt() from types IA and IB
        @Override
        public int getInt() {
            return 0;
        }
    }
    static class CB implements IA {
    }
    static class CC implements IA, IB {
        @Override
        public int getInt() {
            return IB.super.getInt();
        }
    }
    static class CD implements IC {
    }
}

