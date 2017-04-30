package aoeiuv020.annotation;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * Created by AoEiuV020 on 2017/04/30.
 */
public class TargetTypeTest{
    @Test
    public void typeUse() throws Exception {
        Object a = new String();
        @IA
        Object b = a;
        Object c;
        c = (@IA String) a;
        List<@IA Object> list = new ArrayList<@IA Object>(){};
    }
    @Target({ElementType.TYPE_USE})
    static @interface IA {
    }
    @Target({ElementType.TYPE_PARAMETER})
    static @interface IB {
    }
    static class CA<@IA T> {
    }
    static class CB<@IB T> {
    }
}

