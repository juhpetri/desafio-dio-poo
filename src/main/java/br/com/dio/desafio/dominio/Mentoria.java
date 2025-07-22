package br.com.dio.desafio.dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
@EqualsAndHashCode(callSuper = true)
public class Mentoria extends Conteudo {

    private LocalDateTime inicio;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }
}
