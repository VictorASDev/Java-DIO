package collection.set;

import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Set<String> coresDaBandeiraDoBrasil = new TreeSet<>(Arrays.asList("verde", "amarelo", "azul", "branco"));
        System.out.println(coresDaBandeiraDoBrasil);
    }
}
