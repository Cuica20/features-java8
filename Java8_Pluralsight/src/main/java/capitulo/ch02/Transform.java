package capitulo.ch02;

import java.util.List;
import java.util.ArrayList;
import static capitulo.ch02.Folks.friends;

public class Transform {
    public static void main( final String[] args ) {
        {
            // self-inflicted wound pattern...
            final List<String> uppercaseNames = new ArrayList<String>();
            for ( String name : friends ) {
                uppercaseNames.add( name.toUpperCase() );
            }
            System.out.println( "for x in y...." + uppercaseNames );
        }
        {
            final List<String> uppercaseNames = new ArrayList<String>();
            friends.forEach( name -> uppercaseNames.add( name.toUpperCase() ) );
            System.out.println( "Iterable.forEach lambda expression, type inference..." + uppercaseNames );
        }

        System.out.print( "Stream.map over Iterable.forEach..." );
        friends.stream().map( name -> name.toUpperCase() ).forEach( name -> System.out.print( name + " " ) );

        System.out.print( "\nStream.map over Iterable.forEach, different type..." );
        friends.stream().map( name -> name.length() )
                .forEach( count -> System.out.print( count.getClass().getSimpleName() + "( " + count + " ) " ) );

        System.out.print( "\nStream.map with Method Reference over Iterable.forEach..." );
        friends.stream().map( String::toUpperCase ).forEach( name -> System.out.print( name + " " ) );
    }

}
