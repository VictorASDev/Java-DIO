package collection.desafios;

import java.util.Arrays;
import java.util.List;

public class EncontrarProduto {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Long produto = numeros.stream()
                .map(Long::valueOf)
                .reduce(1L, (n1, n2) -> n1 * n2);

        System.out.println(produto);

    }
}
