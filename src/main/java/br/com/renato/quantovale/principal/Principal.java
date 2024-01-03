package br.com.renato.quantovale.principal;

import br.com.renato.quantovale.model.*;
import br.com.renato.quantovale.service.ConsumoAPI;
import br.com.renato.quantovale.service.ConverteDados;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    String enderecoAPI = "https://parallelum.com.br/fipe/api/v1/";
    private String json;
    private
    ConsumoAPI consumidor = new ConsumoAPI();
    public void exibeMenu() {
        int tipoVeiculo = 0;
        int codigoMarca = 0;
        int codigoModelo = 0;
        String nomeModelo;

        System.out.println("Escolha uma das buscas abaixo:\n" +
                "1 - Carros\n" +
                "2 - Motos\n" +
                "3 - Caminhões");
        tipoVeiculo = leitura.nextInt();
        leitura.nextLine();

        System.out.println("Opção selecionada: " + tipoVeiculo);

        switch (tipoVeiculo) {
            case 1:
                enderecoAPI += "carros/marcas";
                break;
            case 2:
                enderecoAPI += "motos/marcas";
                break;
            case 3:
                enderecoAPI += "caminhoes/marcas";
                break;
            default:
                System.out.println("Opção inválida");
        }
        json = consumidor.obterDados(enderecoAPI);
        ConverteDados conversor = new ConverteDados();

        try {
            List<Marca> marcas = conversor.obterDados(json, new TypeReference<List<Marca>>() {});
            System.out.println(marcas);
        } catch (Exception e) {
            System.err.println("Erro ao desserializar as marcas" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Digite o código da marca que deseja buscar: \n");
        codigoMarca = leitura.nextInt();
        leitura.nextLine();

        enderecoAPI += "/" + codigoMarca + "/modelos";
        json = consumidor.obterDados(enderecoAPI);
        try {
            TypeReference<Modelo> typeReference = new TypeReference<Modelo>() {};
            Modelo modelo = conversor.obterDados(json, typeReference);
            List<DadosModelo> modelos = modelo.getModelos();
            System.out.println(modelos);

            System.out.println("Digite o nome do modelo que deseja filtrar: ");
            nomeModelo = leitura.nextLine();

            List<DadosModelo> modelosFiltrados = DadosModelo.filtrarPorNome(modelos,nomeModelo);
            System.out.println("Resultado da busca: \n");
            System.out.println(modelosFiltrados);

        }catch (Exception e){
            System.err.println("Erro ao desserializar os modelos" + e.getMessage());
            e.printStackTrace();
        }


        System.out.println("Digite o código do modelo que deseja buscar: \n");
        codigoModelo = leitura.nextInt();

        enderecoAPI += "/" + codigoModelo + "/anos";
        json = consumidor.obterDados(enderecoAPI);
        List<AvaliacaoVeiculo> avaliacoes = new ArrayList<>();
        try {
            List<AnoModelo> anosmodelo = conversor.obterDados(json, new TypeReference<List<AnoModelo>>() {});
            StringBuilder builder = new StringBuilder();
            builder.append(enderecoAPI + "/");

            for (AnoModelo ano : anosmodelo ) {
                enderecoAPI = builder.append(ano.codigo()).toString();
                json = consumidor.obterDados(enderecoAPI);
                TypeReference<AvaliacaoVeiculo> avaliacaoVeiculoTypeReference = new TypeReference<>() {};
                AvaliacaoVeiculo avaliacao = conversor.obterDados(json, avaliacaoVeiculoTypeReference);
                avaliacoes.add(avaliacao);
                enderecoAPI = builder.delete(enderecoAPI.length() - ano.codigo().length(), enderecoAPI.length()).toString();

            }

            System.out.println(avaliacoes);
        }catch (Exception e){
            System.err.println("Erro ao desserializar os anos do modelos" + e.getMessage());
            e.printStackTrace();
        }
    }
}
