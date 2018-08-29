package capitulo.ch06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyStreams {
    private static int length( final String name ) {
        System.out.println( "getting length for " + name );
        return name.length();
    }

    private static String toUpper( final String name ) {
        System.out.println( "converting to uppercase: " + name );
        return name.toUpperCase();
    }

    // ...
    public static void main( final String[] args ) {
        List<String> names = Arrays.asList(
                "Brad",
                "Kate",
                "Kim",
                "Jack",
                "Joe",
                "Mike",
                "Susan",
                "George",
                "Robert",
                "Julia",
                "Parker",
                "Benson" );
        swingForTheFence( names );
        peekingIntoLaziness( names );
    }

    private static void swingForTheFence( List<String> names ) {
        System.out.println("begin swingForTheFence" );
        final String firstNameWith3Letters = names.stream()
                .filter( name -> length( name ) == 3 )
                .map( name -> toUpper( name ) )
                .findFirst()
                .get();
        System.out.println( firstNameWith3Letters );
        System.out.println("end swingForTheFence" );
    }

    private static void peekingIntoLaziness( List<String> names ) {
        System.out.println("begin peekingIntoLaziness" );
        Stream<String> namesWith3Letters = names.stream()
                .filter( name -> length( name ) == 3 )
                .map( name -> toUpper( name ) );

        System.out.println( "Stream created, filtered, mapped..." );
        System.out.println( "ready to call findFirst..." );
        final String firstNameWith3Letters = namesWith3Letters.findFirst()
                .get();
        System.out.println( firstNameWith3Letters );
        System.out.println("end peekingIntoLaziness" );
    }
}
