package br.com.lucasnog.cadastrocep;

import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.*;

public class Main {
    public static void main(String[] args){

        ICepService service = new CepMemoriaService();
        boolean continuar = true;
        IUIService userService = UISelectService.selectMode();

        do{
            try{
                switch (userService.menuPrincipal()) {
                    case 1:
                        userService.exibir(service.cadastrar(userService.cadastro()));
                        break;
                    case 2:
                        userService.exibir(service.listar());
                        break;
                    case 3:
                        userService.exibir(service.obterPeloNumero(userService.entradaCep()));
                        break;
                    case 4:
                        userService.exibir(service.atualizarPeloNumero(userService.entradaCep(), userService.opcaoModificar(), userService.novoNome()));
                        break;
                    case 5:
                        userService.exibir(service.deletar(userService.entradaCep()));
                        break;
                    case 6:
                        userService.exibir("Até logo!");
                        continuar = false;
                        break;
                    default:
                        userService.exibir("Digite uma opção valida.");
                 }
            }catch (CepInvalidoException e){
                userService.exibir(e.getMessage());
            }

        }while(continuar);
    }
}