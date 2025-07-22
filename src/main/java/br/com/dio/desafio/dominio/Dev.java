package br.com.dio.desafio.dominio;

import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Data
public class Dev {
    private String nome;
    private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudoInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> firstConteudo = this.conteudoInscritos.stream().findFirst();
        firstConteudo.ifPresent(conteudo -> {
            conteudoConcluidos.add(conteudo);
            conteudoInscritos.remove(conteudo);
        });

    }

    public double calcularTotalXp() {
        return this.conteudoConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }
}
