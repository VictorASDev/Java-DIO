package collection.consumer;

import java.util.List;
import java.util.stream.Stream;

public class UsoSupplier {
    public static void main(String[] args) {
        List<String> saudacoes = Stream.generate(() -> "Olá, Munco!").limit(5).toList();

        saudacoes.forEach(System.out::println);
    }

}
