package capitulo.ch07;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.BiFunction;

public class Memoizer {
    public static <T, R> R callMemoized( final BiFunction<Function<T, R>, T, R> function, final T input ) {
        Function<T, R> memoized = new Function<T, R>() {
            {
                /*
                 * WingDing thinks maybe this Map is in the wrong place since
                 * the Price list was fixed at RodCutterMemoizer why wasn't this
                 * Map fixed down at that time as well.
                 */
                System.out.println( "new Function called" );
            }
            private final Map<T, R> store = new HashMap<>();

            public R apply( final T input ) {
                return store.computeIfAbsent( input, key -> function.apply( this, key ) );
            }
        };
        return memoized.apply( input );
    }
}
