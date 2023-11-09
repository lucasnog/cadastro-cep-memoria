package br.com.lucasnog.cadastrocep;

import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.CepMemoriaService;
import br.com.lucasnog.cadastrocep.service.ICepService;
import br.com.lucasnog.cadastrocep.service.UIService;


public class Main {
    public static void main(String[] args){

        ICepService service = new CepMemoriaService();
        UIService userService = new UIService();
        Integer op;
        boolean continuar = true;
        System.out.println("- Sistema de cadastro de CEP -");

        do{
            try{
                op = userService.menuPrincipal();
                switch (op) {
                    case 1:
                        service.cadastrar(userService.cadastro());
                        break;
                    case 2:
                        System.out.println(service.listar());
                        break;
                    case 3:
                        System.out.println(service.obterPeloNumero(userService.entradaCep()));
                        break;
                    case 4:
                        service.atualizarPeloNumero(userService.entradaCep(), userService.opcaoModificar(), userService.novoNome());
                        break;
                    case 5:
                        service.deletar(userService.entradaCep());
                        break;
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