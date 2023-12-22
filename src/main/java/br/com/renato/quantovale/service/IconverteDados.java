package br.com.renato.quantovale.service;

public interface IconverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
