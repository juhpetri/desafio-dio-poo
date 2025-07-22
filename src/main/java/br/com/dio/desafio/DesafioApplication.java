package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDateTime;

public class DesafioApplication {

    public static void main(String[] args) {
        var cursoJava = createCurso("Java", 8);
        var cursoJavaScript = createCurso("JavaScript", 4);
        var mentoria = createMentoria("Java Full Stack");
        var bootcamp = createBootcamp("Java", cursoJava, cursoJavaScript, mentoria);

        var dev = new Dev();
        dev.setNome("João");
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de " + dev.getNome() + ": " + dev.getConteudoInscritos());
        dev.progredir();
        dev.progredir();
        System.out.println("----------------------");
        System.out.println("Conteúdos Inscritos de " + dev.getNome() + ": " + dev.getConteudoInscritos());
        System.out.println("Conteúdos Concluídos de " + dev.getNome() + ": " + dev.getConteudoConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());

        System.out.println("==========================================");
        dev = new Dev();
        dev.setNome("Maria");
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de " + dev.getNome() + ": " + dev.getConteudoInscritos());
        dev.progredir();
        System.out.println("----------------------");
        System.out.println("Conteúdos Inscritos de " + dev.getNome() + ": " + dev.getConteudoInscritos());
        System.out.println("Conteúdos Concluídos de " + dev.getNome() + ": " + dev.getConteudoConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());


    }

    private static Bootcamp createBootcamp(String linguagem, Curso cursoJava, Curso cursoJavaScript, Mentoria mentoria) {
        var bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp " + linguagem + " Full Stack");
        bootcamp.setDescricao("Bootcamp de " + linguagem + " Full Stack com duração de 30 dias.");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJavaScript);
        bootcamp.getConteudos().add(mentoria);
        return bootcamp;
    }

    private static Curso createCurso(String linguagem, int cargaHoraria) {
        var curso = new Curso();
        curso.setTitulo("Curso de " + linguagem);
        curso.setCargaHoraria(cargaHoraria);
        curso.setDescricao("Curso de " + linguagem + " com " + cargaHoraria + " horas de duração.");
        return curso;
    }

    private static Mentoria createMentoria(String linguagem) {
        var mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de " + linguagem);
        mentoria.setDescricao("Mentoria de " + linguagem + " com duração de 20 horas.");
        mentoria.setInicio(LocalDateTime.now());
        return mentoria;
    }
}
