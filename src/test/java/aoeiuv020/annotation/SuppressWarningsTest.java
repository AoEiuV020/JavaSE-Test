package aoeiuv020.annotation;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 没用，SuppressWarnings和Target没有TYPE_USE和TYPE_PARAMETERS,
 * Created by AoEiuV020 on 2017/04/30.
 */
public class SuppressWarningsTest{
    @Test
    public void unchecked() throws Exception {
        //这个定义变量语句，java8之前就支持，
        @SuppressWarnings("unchecked")
        List<Integer> list = new ArrayList();
        //list =(@SuppressWarnings("unchecked") List<Integer>) new ArrayList(); //annotation type not applicable to this kind of declaration
    }
}

