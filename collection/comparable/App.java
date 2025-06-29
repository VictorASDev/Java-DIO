package collection.comparable;

import collection.Livro;
import collection.comparator.CompararPorTamanho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Livro> lista = new ArrayList();

        for (int i = 0; i < 3; i++) {
            String nome = sc.nextLine();
            Livro livro = new Livro(nome, 2);
            lista.add(livro);
        }

        Collections.sort(lista);

        for (Livro livro : lista) {
            livro.imprimir();
        }

        Collections.sort(lista, new CompararPorTamanho());
        for (Livro livro : lista) {
            livro.imprimir();
        }
    }
}
