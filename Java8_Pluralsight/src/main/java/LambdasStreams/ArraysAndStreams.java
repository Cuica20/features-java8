package LambdasStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

    public static void main(String[] args) {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        System.out.printf("Valores originales: %s%n", Arrays.asList(values));

        System.out.printf("Orden de valores: %s%n",
                Arrays.stream(values)
                        .sorted()
                        .collect(Collectors.toList()));

        List<Integer> greaterThan4 =
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .collect(Collectors.toList());

        System.out.printf("Valores mayores que 4: %s%n",
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));

        System.out.printf(
                "Valores mayores que 4 (ascendente con Streams): %s%n",
                greaterThan4.stream()
                        .sorted()
                        .collect(Collectors.toList()));

    }
}
