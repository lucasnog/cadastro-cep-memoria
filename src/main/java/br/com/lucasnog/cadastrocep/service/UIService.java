package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.Scanner;

public class UIService {
    String rua, cidade, estado;
    Integer cepNumero;
    Scanner sc = new Scanner(System.in);


    public Integer menuPrincipal(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar novo CEP");
        System.out.println("2 - Listar todos os CEPs");
        System.out.println("3 - Buscar CEP");
        System.out.println("4 - Modificar CEP");
        System.out.println("5 - Excluir CEP");
        System.out.println("6 - Sair");



        return sc.nextInt();
    }

    public Cep cadastro() throws CepInvalidoException {

        System.out.println("Digite o numero do CEP:");
        cepNumero = sc.nextInt();
        sc.nextLine();


        if (cepNumero.toString().length() != 8) {
            throw new CepInvalidoException("Número de digitos inválido.");
        }

        System.out.println("Digite o nome da rua:");
        rua = sc.nextLine();

        System.out.println("Digite o nome da cidade:");
        cidade = sc.nextLine();

        System.out.println("Digite o nome do estado:");
        estado = sc.nextLine();

        return new Cep(cepNumero, rua, cidade, estado);
    }

    public Integer entradaCep(){
        System.out.println("Digite o numero do CEP:");
        return  sc.nextInt();
    }



    public Integer opcaoModificar(){
        System.out.println("O que deseja alterar?");
        System.out.println("1 - rua");
        System.out.println("2 - cidade");
        System.out.println("3 - estado");

        return sc.nextInt();
    }

    public String novoNome(){
        System.out.println("Alterar para:");
        return sc.next();
    }
}
