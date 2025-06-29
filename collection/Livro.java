package collection;

import java.util.Objects;

public class Livro implements Comparable<Livro>{
    private String titulo;
    private int id;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }


    public Livro(String titulo, int id) {
        this.id = id;
        this.titulo = titulo;
    }

    @Override
    //Comparar pelo ano do livro
    public int compareTo(Livro l) {
        return titulo.compareTo(l.titulo);
    }

    public void imprimir() {
        System.out.println(titulo);
        System.out.println("_________________");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return getId() == livro.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }
}
