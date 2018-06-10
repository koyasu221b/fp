import org.junit.Assert;
import org.junit.Test;


public class testCompose {
    @Test
    public void test(){

    /*

       default <V> Function<V, U> compose(Function<V, T> f) {

        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        System.out.println(times2.compose(squared).apply(4));



        e -> ((e -> e * e) * 2 )
        V  =>  ((V => T ))
     */
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;

        Assert.assertEquals(32, (long)times2.compose(squared).apply(4));


        Function<Integer, Integer> a = times2.compose(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * arg;
            }
        });

        Assert.assertEquals(32,(long) a.apply(4));

    }

    @Test
    public void test2(){
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
//        Assert.assertEquals(32, (long)times2.compose2(squared).apply(4));
    }

    @Test
    public void test3(){
        Function<Integer, Integer> triple = x -> x * 3;
        Function<Integer, Integer> squared = x -> x * x;
//        Assert.assertEquals(32, );
        Function<Integer, Integer> f = Function.compose3(squared, triple);
        Assert.assertEquals(36, (long) f.apply(2));

    }
}
