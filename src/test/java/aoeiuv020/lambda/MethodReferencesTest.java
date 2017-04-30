package aoeiuv020.lambda;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by AoEiuV020 on 2017/04/30.
 */
public class MethodReferencesTest{
    @Test
    public void method() throws Exception {
        List<A> list=new ArrayList<>();
        list.add(new A(8));
        list.add(new A(2));
        list.add(new A(10));
        list.sort((a,b)->a.getAge().compareTo(b.getAge()));
        list.sort(A::compareTo);
        list.sort(A::compare);
        assertEquals("[2, 8, 10]", list.toString());
    }
    static class A {
        Integer age;
        A(Integer age){
            this.age=age;
        }
        Integer getAge(){
            return age;
        }
        int compareTo(A b) {
           return this.age.compareTo(b.age); 
        }
        static int compare(A a, A b) {
            return a.compareTo(b);
        }
        @Override
        public String toString() {
            return age.toString();
        }
    }
}

