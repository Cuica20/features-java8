package capitulo.ch02;

import static capitulo.ch02.Folks.comrades;
import static capitulo.ch02.Folks.editors;
import static capitulo.ch02.Folks.friends;

import java.util.function.Predicate;

public class PickElementsMultipleCollection {
    public static void main( final String[] args ) {
        {
            final long countFriendsStartN = friends.stream().filter( name -> name.startsWith( "N" ) ).count();
            // Yuk..
            final long countEditorsStartN = editors.stream().filter( name -> name.startsWith( "N" ) ).count();
            // Yuk.
            final long countComradesStartN = comrades.stream().filter( name -> name.startsWith( "N" ) ).count();

            System.out.println( countFriendsStartN );
            System.out.println( countComradesStartN );
            System.out.println( countEditorsStartN );
        }

        {
            // Thats better...
            final Predicate<String> startsWithN = name -> name.startsWith( "N" );

            final long countFriendsStartN = friends.stream().filter( startsWithN ).count();
            final long countEditorsStartN = editors.stream().filter( startsWithN ).count();
            final long countComradesStartN = comrades.stream().filter( startsWithN ).count();

            System.out.println( countFriendsStartN );
            System.out.println( countComradesStartN );
            System.out.println( countEditorsStartN );
        }
    }

}
