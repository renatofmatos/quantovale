package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelo {
    private List<DadosModelo> modelos;

    public List<DadosModelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<DadosModelo> modelos) {
        this.modelos = modelos;
    }
}
