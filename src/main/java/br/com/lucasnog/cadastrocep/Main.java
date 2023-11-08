package br.com.lucasnog.cadastrocep;

import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.CepMemoriaService;
import br.com.lucasnog.cadastrocep.service.ICepService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CepInvalidoException {

        ICepService service = new CepMemoriaService();
        Integer cepNumero, op;
        boolean continuar = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("- Sistema de cadastro de CEP -");
        do{
            try{
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Cadastrar novo CEP");
                System.out.println("2 - Listar todos os CEPs");
                System.out.println("3 - Buscar CEP");
                System.out.println("4 - Modificar CEP");
                System.out.println("5 - Excluir CEP");
                System.out.println("6 - Sair");

                op = sc.nextInt();

                switch (op) {
                    case 1:

                        System.out.println("Digite o numero do CEP:");
                        cepNumero = sc.nextInt();

                        if(!service.checkExiste(cepNumero)) {
                            service.cadastrar(cepNumero);
                        }else{
                            throw new CepInvalidoException("Cep já está cadastrado.");
                        }
                        break;

                    case 2:
                        System.out.println(service.listar());
                        break;
                    case 3:
                        System.out.println("Digite o numero do CEP:");
                        cepNumero = sc.nextInt();
                        if(service.checkExiste(cepNumero)) {
                            service.obterPeloNumero(cepNumero);
                        }else{
                            throw new CepInvalidoException("CEP não encontrado no sistema.");
                        }
                        break;
                    case 4:
                        System.out.println("Qual CEP deseja modificar?");
                        cepNumero = sc.nextInt();

                        if (!service.checkExiste(cepNumero)){
                            throw new CepInvalidoException("CEP não encontrado no sistema.");
                        };

                        int mod;
                        System.out.println("O que deseja alterar?");
                        System.out.println("1 - rua");
                        System.out.println("2 - cidade");
                        System.out.println("3 - estado");
                        mod = sc.nextInt();
                        sc.nextLine();
                        service.atualizarPeloNumero(cepNumero, mod);
                        break;

                    case 5:
                        System.out.println("Qual CEP deseja excluir?");
                        cepNumero = sc.nextInt();

                        if(service.checkExiste(cepNumero)){
                            service.deletar(cepNumero);
                        }else{
                            throw new CepInvalidoException("Cep não encontrado no sistema.");
                        }
                    case 6:
                        System.out.println("Até logo!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Digite uma opção valida.");
                 }
            }catch (CepInvalidoException e){
                System.out.println(e.getMessage());
            }
        }while(continuar);
    }
}