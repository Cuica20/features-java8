package capitulo.ch02;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static capitulo.ch02.Folks.friends;

public class PickElements {
    public static void main( final String[] args ) {
        {
            // self-inflicted wound pattern...
            final List<String> startsWithN = new ArrayList<String>();
            for ( String name : friends ) {
                if ( name.startsWith( "N" ) ) {
                    startsWithN.add( name );
                }
            }
            System.out.println( String.format( "for x in y...Found %d names", startsWithN.size() ) );
        }

        final List<String> startsWithN = friends.stream().filter( name -> name.startsWith( "N" ) ).collect( Collectors.toList() );
        System.out.println( String.format( "Stream.filter.collect...Found %d names", startsWithN.size() ) );
    }

}
