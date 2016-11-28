package com.parkingwng.lang;


import com.parkingwng.lang.kit.StringKit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.0
 */
public class StreamTest {

    @Test
    public void test(){
        final List<String> output = Stream.of(1,2,3,4,5,6,7,8,9)
                .filter(new Filter<Integer>() {
                    @Override
                    public boolean filter(Integer item) {
                        return item % 2 == 0;
                    }
                })
                .map(new Transformer<Integer, String>() {
                    @Override
                    public String transform(Integer in) {
                        return "S" + in;
                    }
                })
                .toList();

        final String content = StringKit.join(output, ",");
        System.out.println(content);
        Assert.assertEquals("S2,S4,S6,S8", content);
    }

    @Test
    public void restReduce(){
        final int sum = Stream.of(1,2,3,4,5,6,7,8,9,10).reduce(new Accumulator<Integer>() {
            @Override
            public Integer invoke(Integer e1, Integer e2) {
                return e1 + e2;
            }
        });
        Assert.assertEquals(55, sum);
    }
}
