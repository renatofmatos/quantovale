package br.com.renato.quantovale.principal;

import br.com.renato.quantovale.model.DadosMarca;
import br.com.renato.quantovale.service.ConsumoAPI;
import br.com.renato.quantovale.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    String enderecoAPI = "https://parallelum.com.br/fipe/api/v1/";
    private String json;
    private
    ConsumoAPI consumidor = new ConsumoAPI();
    public void exibeMenu() {
        int opcaoMenu = 0;

        System.out.println("Escolha uma das buscas abaixo:\n" +
                "1 - Carros\n" +
                "2 - Motos\n" +
                "3 - Caminhões");
        opcaoMenu = leitura.nextInt();

        System.out.println("Opção selecionada: " + opcaoMenu);

        switch (opcaoMenu) {
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


        System.out.println(json);

        try {
            List<DadosMarca> marcas = conversor.obterDados(json,List.class);
            System.out.println(marcas);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
