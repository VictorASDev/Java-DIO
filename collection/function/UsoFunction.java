package collection.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UsoFunction {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5);
        List<Integer> listaDobrada = lista.stream().map(numero -> numero * 2).toList();

        listaDobrada.forEach(System.out::println);
    }
}
