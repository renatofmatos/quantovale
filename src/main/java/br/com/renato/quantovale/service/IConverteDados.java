package br.com.renato.quantovale.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverteDados {
    <T> T obterDados(String json, TypeReference<T> tipo);

}
