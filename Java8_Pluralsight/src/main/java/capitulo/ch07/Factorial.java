package capitulo.ch07;

import static capitulo.ch07.TailCalls.done;
import static capitulo.ch07.TailCalls.call;

public class Factorial {
    public static int factorialRec( final int number ) {
        if ( number == 1 ) {
            return number;
        } else {
            return number * factorialRec( number - 1 );
        }
    }

    public static int factorial( final int number ) {
        return factorialTailRec( 1, number ).invoke();
    }

    public static TailCall<Integer> factorialTailRec( final int factorial, final int number ) {
        if ( number == 1 ) {
            return done( factorial );
        } else {
            return call( ( ) -> factorialTailRec( factorial * number, number - 1 ) );
        }
    }

    public static void main( final String[] args ) {
        System.out.println( "// factorialRec( 5 ) start" );
        System.out.println( factorialRec( 5 ) );
        System.out.println( "// factorialRec( 5 ) end\n" );

        System.out.println( "// factorialRec( 20000 ) start" );
        try {
            System.out.println( factorialRec( 20000 ) );
        } catch ( StackOverflowError ex ) {
            System.out.println( ex );
        }
        System.out.println( "// factorialRec( 20000 ) end\n" );

        System.out.println( "// factorialTailRec( 1, 5 ) start" );
        System.out.println( factorialTailRec( 1, 5 ).invoke() );
        System.out.println( "// factorialTailRec( 1, 5 ) end\n" );

        System.out.println( "// factorialTailRec( 1, 20000 ) start" );
        System.out.println( factorialTailRec( 1, 20000 ).invoke() );
        System.out.println( "// factorialTailRec( 1, 20000 ) end\n" );

        System.out.println( "// factorial( 5 ); factorial( 20000 ); start" );
        System.out.println( factorial( 5 ) );
        System.out.println( factorial( 20000 ) );
        System.out.println( "// factorial( 5 ); factorial( 20000 ); end\n" );

    }
}
