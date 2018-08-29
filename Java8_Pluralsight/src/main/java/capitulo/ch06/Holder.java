  package capitulo.ch06;

import java.util.function.Supplier;

public class Holder {
    class HeavyFactory implements Supplier<Heavy> {
        private final Heavy heavyInstance = new Heavy();

        public Heavy get() {
            return heavyInstance;
        }
    }

    private Supplier<Heavy> heavySupplier = ( ) -> createAndCacheHeavy();

    public Holder() {
        System.out.println( "Holder created" );
    }

    private synchronized Heavy createAndCacheHeavy() {
        if ( !HeavyFactory.class.isInstance( heavySupplier ) ) {
            heavySupplier = new HeavyFactory();
        }
        return heavySupplier.get();
    }

    public Heavy getHeavy() {
        return heavySupplier.get();
    }

    public static void main( final String[] args ) {
        final Holder holder = new Holder();
        System.out.println( "deferring heavy creation..." );
        System.out.println( holder.getHeavy() );
        System.out.println( holder.getHeavy() );
    }
}
