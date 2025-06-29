package collection.predicate;

import java.util.Arrays;
import java.util.List;

public class UsoPredicate {
    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("Victor", "Davi", "Ana", "Vanessa");

        listaNomes.stream().filter(nome -> {
            return nome.startsWith("V");
        }).forEach(System.out::println);
    }
}
