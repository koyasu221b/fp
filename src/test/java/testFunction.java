import org.junit.Assert;
import org.junit.Test;

public class testFunction {
    @Test
    public void test(){
        Function<Integer, Integer> tripple = x -> x * 3;

//        Function<Integer, Integer> tripple2 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer arg) {
//                return arg*3;
//            }
//        };

        System.out.println(tripple.apply(3));
    }

    @Test
    public void test2(){
        Function<Integer, Function<Integer, Integer>> add = x-> (y -> x + y);
        long expected = 9;
        Assert.assertEquals(expected, (long) add.apply(3).apply(6));




        BinaryOperator add2 = x -> (y -> x + y) ;
        Assert.assertEquals(expected, (long) add2.apply(3).apply(6));

        Function<Integer, Function<Integer, Integer>> add3 = new Function<Integer, Function<Integer, Integer>>() {
            @Override
            public Function<Integer, Integer> apply(Integer x) {
                return new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer y) {
                        return x+y;
                    }
                };
            }
        };

        Assert.assertEquals(expected, (long) add3.apply(3).apply(6));

    }

    @Test
    public void test3(){
        Function<Integer, Function<Integer, Integer>> add = x-> (y -> 5 + y);
        long expected = 5;
        Assert.assertEquals(expected, (long) add.apply(3).apply(0));
    }

    @Test
    public void test4(){
        Function<Integer, Function<Integer, Integer>> add = x-> (y -> 5 + x);
        long expected = 8;
        Assert.assertEquals(expected, (long) add.apply(3).apply(0));


    }

    @Test
    public void test5(){

        Function<Integer, Function<Integer, Integer>> mul= x-> (y -> x * y);
        Function<Integer, Integer> mul3 = mul.apply(3);
        Assert.assertEquals(27, (long)mul3.apply(9));

        Function<Integer, Integer> mul4 = mul.apply(4);
        Assert.assertEquals(36, (long)mul4.apply(9));

        Assert.assertEquals(27, (long) mul.apply(3).apply(9));
    }

}
