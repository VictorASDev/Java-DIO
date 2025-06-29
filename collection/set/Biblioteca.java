package collection.set;

import collection.Livro;

import java.util.Set;
import java.util.HashSet;


public class Biblioteca {
    Set<Livro> biblioteca = new HashSet<Livro>();

    public void adicionarLivro(String titulo, int id) {
        biblioteca.add(new Livro(titulo, id));
    }

    public void removerLivro(int id) {
        for (Livro livro : biblioteca) {
            if (livro.getId() == id) {
                biblioteca.remove(livro);
                break;
            }
        }
    }

    public void imprimirLivros() {
        for (Livro livro : biblioteca) {
            livro.imprimir();
        }
    }

    
}
