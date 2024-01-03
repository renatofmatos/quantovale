package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnoModelo(
    @JsonProperty("codigo")
    String codigo,
    @JsonProperty("nome")
    String nome){

}
