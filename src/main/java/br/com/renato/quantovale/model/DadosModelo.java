package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;

public record DadosModelo(
        @JsonProperty("codigo")
        Integer codigo,
        @JsonProperty("nome") String nome) {
        public static List<DadosModelo> filtrarPorNome(List<DadosModelo> modelos, String nome ){

                return modelos.stream()
                        .filter(modelo -> modelo.nome().toLowerCase().contains(nome.toLowerCase()))
                        .collect(Collectors.toList());
        }
        @Override
        public String toString() {
                return "\nCódigo: " + codigo
                        + " Nome: " + nome;
        }
}
