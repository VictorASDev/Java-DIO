package collection.desafios;

import java.util.Arrays;
import java.util.List;

public class SomarDigitos {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        System.out.println(numeros.stream().flatMapToInt(n -> String.valueOf(n).chars())
                .map(n -> n - '0').sum());
    }
}
