package capitulo.ch02;

import static capitulo.ch02.Folks.friends;

import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {
    public static void main( final String[] args ) {
        { // There is obvious room for improvement here...
            final Predicate<String> startsWithN = name -> name.startsWith( "N" );
            final Predicate<String> startsWithB = name -> name.startsWith( "B" );

            final long countFriendsStartN = friends.stream()
                    .filter( startsWithN )
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter( startsWithB )
                    .count();

            System.out.println( "countFriendsStartN: " + countFriendsStartN );
            System.out.println( "countFriendsStartB: " + countFriendsStartB );
        }
        { // BobK says "remove duplication like you already know how to"...
            final Predicate<String> startsWithNorB = name -> ( name.startsWith( "N" ) || name.startsWith( "B" ) );

            final long countFriendsStartNorB = friends.stream()
                    .filter( startsWithNorB )
                    .count();

            System.out.println( "countFriendsStartNorB: " + countFriendsStartNorB );
        }
        { // BobK says "lookie at that .or thing on Predicate"...
            final Predicate<String> startsWithN = name -> name.startsWith( "N" );
            final Predicate<String> startsWithB = name -> name.startsWith( "B" );

            final long countFriendsStartNorB = friends.stream()
                    .filter( startsWithN.or( startsWithB ) )
                    .count();

            System.out.println( "countFriendsStartNorB: " + countFriendsStartNorB );
        }
        { // P31: Venkat says "Remove Duplication with Lexical Scoping"...
            final long countFriendsStartN = friends.stream()
                    .filter( checkIfStartsWith( "N" ) )
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter( checkIfStartsWith( "B" ) )
                    .count();

            System.out.println( "countFriendsStartN: " + countFriendsStartN );
            System.out.println( "countFriendsStartB: " + countFriendsStartB );
        }
        { // Venkat says
          // "We don't want to pollute the class with static methods"...
            final Function<String, Predicate<String>> startsWithLetter = ( String letter ) -> {
                Predicate<String> checkStarts = ( String name ) -> name.startsWith( letter );
                return checkStarts;
            };

            final long countFriendsStartN = friends.stream()
                    .filter( startsWithLetter.apply( "N" ) )
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter( startsWithLetter.apply( "B" ) )
                    .count();

            System.out.println( "countFriendsStartN: " + countFriendsStartN );
            System.out.println( "countFriendsStartB: " + countFriendsStartB );
        }
        { // Venkat says
          // "Replace the explicit Predicate instance with a lambda expression"...
            final Function<String, Predicate<String>> startsWithLetter = ( String letter ) -> ( String name ) -> name.startsWith( letter );

            final long countFriendsStartN = friends.stream()
                    .filter( startsWithLetter.apply( "N" ) )
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter( startsWithLetter.apply( "B" ) )
                    .count();

            System.out.println( "countFriendsStartN: " + countFriendsStartN );
            System.out.println( "countFriendsStartB: " + countFriendsStartB );
        }
        { // Venkat says
          // "let the Java compiler infer the types based on the context"...
            final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith( letter );

            final long countFriendsStartN = friends.stream()
                    .filter( startsWithLetter.apply( "N" ) )
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter( startsWithLetter.apply( "B" ) )
                    .count();

            System.out.println( "countFriendsStartN: " + countFriendsStartN );
            System.out.println( "countFriendsStartB: " + countFriendsStartB );
        }
        { // TODO: Bob wants a vararg Predicate. Where is George Smith when you
          // need him?
        }
    }

    // Note how this doesn't return boolean, it returns a Predicate.
    public static Predicate<String> checkIfStartsWith( final String letter ) {
        return name -> name.startsWith( letter );
    }

}
