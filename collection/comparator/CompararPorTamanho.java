package collection.comparator;

import java.util.Comparator;
import collection.Livro;

public class CompararPorTamanho implements Comparator<Livro> {
    public int compare(Livro l1, Livro l2) {
        return Integer.compare(l1.getTitulo().length(), l2.getTitulo().length() );
    }
}
