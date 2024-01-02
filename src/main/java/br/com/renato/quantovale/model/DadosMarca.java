package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosMarca(@JsonAlias("codigo") Integer codigoMarca,
                         @JsonAlias("nome") String nomeMarca
                     ) {

}
