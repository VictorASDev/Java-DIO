package collection.binaryOperator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class UsoBinaryOperator {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5);

        System.out.println(lista.stream().reduce(0, (n1, n2) -> n1 + n2));
    }
}
