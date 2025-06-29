public class Curso extends Conteudo{
    private int cargaHoraria;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    protected double calcularXP() {
        return XP_BASE * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo=" + super.getTitulo() + '\'' +
                "descrição=" + super.getDescricao() + '\'' +
                "carga horaria=" + cargaHoraria +
                '}';
    }

}
