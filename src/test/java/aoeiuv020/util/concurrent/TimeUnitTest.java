package aoeiuv020.util.concurrent;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
/**
 * Created by AoEiuV020 on 2017/04/29.
 */
public class TimeUnitTest{
    @Test
    public void toSeconds() throws Exception {
        assertEquals(60,TimeUnit.MINUTES.toSeconds(1));
        assertEquals(60,TimeUnit.SECONDS.convert(1,TimeUnit.MINUTES));
    }
}

