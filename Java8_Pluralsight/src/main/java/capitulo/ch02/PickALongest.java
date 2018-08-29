package capitulo.ch02;

import static capitulo.ch02.Folks.friends;

import java.util.Optional;

public class PickALongest {
    public static void main( final String[] args ) {

        // mapToInt() maps, sum() reduces...
        {
            System.out.println( "Total number of characters in all names: " + friends.stream()
                    .mapToInt( name -> name.length() )
                    .sum() );
        }

        // reduce carries forward its result...
        final Optional<String> aLongName = friends.stream()
                .reduce( ( name1, name2 ) -> name1.length() >= name2.length() ? name1 : name2 );
        aLongName.ifPresent( name -> System.out.println( String.format( "A longest name: %s", name ) ) );

        // You can set a default or base value for the reduce and get rid of the
        // Optional...
        final String steveOrLonger = friends.stream()
                .reduce( "Steve", ( name1, name2 ) -> name1.length() >= name2.length() ? name1 : name2 );
        System.out.println( steveOrLonger );
    }
}
