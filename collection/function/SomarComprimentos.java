package collection.function;

import java.util.Arrays;
import java.util.List;

public class SomarComprimentos {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("café", "bolo", "java");

        int soma = palavras.stream()
                .map(String::length)
                .reduce(0, Integer::sum);

        System.out.println("Soma dos comprimentos: " + soma);
    }
}
