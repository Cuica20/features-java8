package capitulo.ch08;

import java.util.stream.Stream;

public class PickStockFunctional {
    public static void findHighPriced( final Stream<String> symbols, String label ) {
        long start = System.currentTimeMillis();
        final StockInfo highPriced = symbols.map( StockUtil::getPrice )
                .filter( StockUtil.isPriceLessThan( 500 ) )
                .reduce( StockUtil::pickHigh )
                .get();
        System.out.println( "High priced under $500 is " + highPriced );
        System.out.println( "Elapsed: " + ( System.currentTimeMillis() - start ) + "ms PickStockFunctional " + label );
    }

    public static void main( final String[] args ) {
        findHighPriced( Tickers.symbols.stream(), "stream" );
        findHighPriced( Tickers.symbols.parallelStream(), "parallelStream" );
    }

}
