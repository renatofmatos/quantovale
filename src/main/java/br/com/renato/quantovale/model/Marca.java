package br.com.renato.quantovale.model;

public class Marca {
    private Integer codigo;
    private String nome;

    @Override
    public String toString() {
        return "Código: " + this.codigo +
                "\n Nome: " + this.nome;
    }
}
