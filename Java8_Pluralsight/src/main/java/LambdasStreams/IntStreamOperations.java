package LambdasStreams;

import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {

        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.println("Valores originales: ");
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        // coun, min , max, sum and average de los valores
        System.out.println("Count = " + IntStream.of(values).count());

        System.out.println("Min() = " + IntStream.of(values).min().getAsInt());

        System.out.println("Max() = " + IntStream.of(values).max().getAsInt());

        System.out.println("Sum() = " + IntStream.of(values).sum());

        System.out.println("Average = " + IntStream.of(values).average().getAsDouble());

        // suma de valores con el metodo reduce
        System.out.println("Suma de valores con el metodo reduce " +
                IntStream.of(values).
                        reduce(0, (x, y) -> x + y));

        // suma de los valores cuadraticos con el metodo reduce
        System.out.println("Suma de los valores cuadraticos con el metodo reduce = " +
                IntStream.of(values).reduce(0, (x, y) -> x + y * y));

        System.out.println("Mostrar los valores pares ordenados = ");
        IntStream.of(values)
                .filter(value -> value % 2 == 0)
                .sorted()
                .forEach(value -> System.out.printf("%d", value));
        System.out.println();

        System.out.printf("Mostrar los valores impares ordenados");
        IntStream.of(values)
                .filter(value -> value % 2 != 0)
                .map(operand -> operand * 10)
                .sorted()
                .forEach(value -> System.out.printf("%d",value));
        System.out.println();

        System.out.printf("%nSuma de integers de 1 a 9: %d%n",
                IntStream.range(1,10).sum());

        System.out.printf("%nSuma de integers de 1 a 10: %d%n",
                IntStream.rangeClosed(1,10).sum());

    }

}
