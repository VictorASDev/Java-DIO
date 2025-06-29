package collection.desafios;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerificarRepeticao {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Set<Integer> unicos = new HashSet<>();
        boolean temRepetidos = numeros.stream().anyMatch(n -> !unicos.add(n));

        System.out.println("Tem repetidos? " + temRepetidos);    }
}
