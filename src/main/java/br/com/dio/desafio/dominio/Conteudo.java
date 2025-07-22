package br.com.dio.desafio.dominio;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    protected String titulo;
    protected String descricao;

    public abstract double calcularXp();
}
