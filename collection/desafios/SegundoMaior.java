package collection.desafios;

import java.util.Arrays;
import java.util.List;

public class SegundoMaior {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        numeros.stream().distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
