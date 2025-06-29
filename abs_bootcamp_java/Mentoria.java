import java.time.LocalDate;

public class Mentoria extends Conteudo{
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    protected double calcularXP() {
        return XP_BASE + 20d;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo=" + super.getTitulo() + '\'' +
                "descrição=" + super.getDescricao() + '\'' +
                "data=" + data +
                '}';
    }
}
