@FunctionalInterface
public interface Function<T, U> {
    U apply(T arg);

    default <V> Function<V, U> compose(Function<V, T> f) {
        return x -> apply(f.apply(x));
    }

//    default <V> Function<V, U> compose2(Function<V, T> f) {
//        return new Function<V, U>() {
//            @Override
//            public U apply(V x) {
//                return (U) f.apply(x);
//            };
//        };
//    }

    static <V, T, U> Function<V, U> compose3(Function<T, U> f, Function<V,T> g){
        return x -> f.apply(g.apply(x));
    };


}
