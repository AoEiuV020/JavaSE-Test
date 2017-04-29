package aoeiuv020.lambda;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.Callable;
/**
 * Created by AoEiuV020 on 2017/04/29.
 */
public class OverloadTest{
    /**
     * 代码仿自官方教程lambda篇，
     * 好像搞错了什么，
     * 反正这里能自动判断是根据lambda的返回值类型和参数类型区分调用哪个重载方法，
     */
    @Test
    public void overload() {
        C obj=new C();
        assertEquals(0,obj.n);
        //obj.notInvoke(() -> fail()); //ambiguous
        obj.notInvoke((Runnable)() -> fail());
        assertEquals(1,obj.n);
        obj.notInvoke(() -> {fail();return 0;});
        assertEquals(6,obj.n);
        obj.notInvoke((Callable)() -> 0);
        assertEquals(8,obj.n);
        obj.notInvoke((C.CallHolder)() -> 0);
        assertEquals(13,obj.n);
        //obj.notInvoke((i) -> fail()); //ambiguous
        obj.notInvoke((int i) -> fail());
        assertEquals(17,obj.n);
        obj.notInvoke((String i) -> fail());
        assertEquals(23,obj.n);
    }
    static class C {
        int n=0;
        void notInvoke(Runnable r) {
            n+=1;
        }
        void notInvoke(Callable<Integer> c){
            n+=2;
        }
        void notInvoke(RunHolder r){
            n+=3;
        }
        void notInvoke(RunWithIntHolder r){
            n+=4;
        }
        /**
         * 这个明明和上面的2冲突了，但是没报错，
         * 而是直接调用了这个，删除这个方法就调用2,
         */
        void notInvoke(CallHolder c){
            n+=5;
        }
        void notInvoke(RunWithStringHolder r){
            n+=6;
        }
        static interface RunHolder {
            void run();
        }
        static interface RunWithIntHolder {
            void run(int arg);
        }
        static interface RunWithStringHolder {
            void run(String arg);
        }
        static interface CallHolder {
            int call();
        }
    }
}
