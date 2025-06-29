import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso sintaxe java");
        curso1.setDescricao("Curso básico sobre a sintaxe da linguagem de programação de java");
        curso1.setCargaHoraria(10);
        System.out.println(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("Bootcamp springboot");
        curso2.setDescricao("Curso sobre o framework springboot usando a linguagem java");
        curso2.setCargaHoraria(15);
        System.out.println(curso2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria - java");
        mentoria.setDescricao("Mentoria de java");
        mentoria.setData(LocalDate.now());
        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.getConteudosPresentes().add(curso1);
        bootcamp.getConteudosPresentes().add(curso2);
        bootcamp.getConteudosPresentes().add(mentoria);

        Dev devVictor = new Dev();
        devVictor.setNome("Victor");
        devVictor.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Victor: " + devVictor.getConteudosInscritos());

        devVictor.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Victor: " + devVictor.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Victor: " + devVictor.getConteudosConcluidos());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos João: " + devJoao.getConteudosConcluidos());

    }
}
