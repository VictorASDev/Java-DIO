package collection.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UsoConsumer {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //implementação explicita da Functional Interface
        Consumer<Integer> imprimirDobro = n -> {
            System.out.println(n*2);
        };

        lista.stream().forEach(imprimirDobro);

        //implementação usual da Functional Interface
        lista.forEach(n -> {
            System.out.println(n + 1);
        });

        //os dois casos criam Consumer´s de formas diferentes, um com a função de imprimir o dobro e o outro somando 1, mas ambos funcionais
    }
}
