import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFinal = LocalDate.now().plusDays(45);
    private Set<Dev> devsIncritos = new HashSet<>();
    private Set<Conteudo> conteudosPresentes = new LinkedHashSet<>();

    public Set<Conteudo> getConteudosPresentes() {
        return conteudosPresentes;
    }

    public void setConteudosPresentes(Set<Conteudo> conteudosPresentes) {
        this.conteudosPresentes = conteudosPresentes;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Dev> getDevsIncritos() {
        return devsIncritos;
    }

    public void setDevsIncritos(Set<Dev> devsIncritos) {
        this.devsIncritos = devsIncritos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(getNome(), bootcamp.getNome()) && Objects.equals(getDescricao(), bootcamp.getDescricao()) && Objects.equals(getDataInicio(), bootcamp.getDataInicio()) && Objects.equals(getDataFinal(), bootcamp.getDataFinal()) && Objects.equals(getDevsIncritos(), bootcamp.getDevsIncritos()) && Objects.equals(getConteudosPresentes(), bootcamp.getConteudosPresentes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDescricao(), getDataInicio(), getDataFinal(), getDevsIncritos(), getConteudosPresentes());
    }
}
