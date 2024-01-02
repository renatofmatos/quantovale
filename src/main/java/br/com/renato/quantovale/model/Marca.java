package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Marca {
    @JsonProperty("codigo") private Integer codigo;
    @JsonProperty("nome") private String nome;

    @Override
    public String toString() {
        return "\nCódigo: " + codigo +
                " Nome: " + nome;
    }
}
