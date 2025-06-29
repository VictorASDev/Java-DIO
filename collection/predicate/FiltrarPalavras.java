package collection.predicate;

import java.util.Arrays;
import java.util.List;

public class FiltrarPalavras {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Java", "é", "muito", "legal", "e", "divertido");

        long total = palavras.stream()
                .filter(p -> p.length() > 3)
                .count();

        System.out.println("Número de palavras com mais de 5 letras: " + total);
    }
}
