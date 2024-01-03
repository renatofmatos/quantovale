package br.com.renato.quantovale.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvaliacaoVeiculo {
    @JsonProperty("Valor")
    private String valor;
    @JsonProperty("Marca")
    private String marca;
    @JsonProperty("Modelo")
    private String modelo;
    @JsonProperty("AnoModelo")
    private int ano;
    @JsonProperty("Combustivel")
    private String combustivel;
    @JsonProperty("CodigoFipe")
    private String codigoFipe;
    @JsonProperty("MesReferencia")
    private String mesReferencia;

    public AvaliacaoVeiculo() {
    }

    public AvaliacaoVeiculo(String valor, String marca, String modelo, int ano, String combustivel, String codigoFipe, String mesReferencia) {
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
    }

    public double getValor() {
        if (valor != null){
            try{
                return Double.parseDouble(valor);
            }catch (NumberFormatException e){
                System.err.println("Erro ao desserializar os anos do modelos" + e.getMessage());
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    @Override
    public String toString() {
        return  "\n------------------------------------------------------------\n"+
                "Valor: "+ valor +
                "\nMarca: " + marca +
                "\n Modelo: " + modelo+
                "\n Ano Modelo: " + ano+
                "\n Combustível: " + combustivel+
                "\n Cód Fipe: " + codigoFipe+
                "\n Mês Referência: " + mesReferencia;
    }
}
