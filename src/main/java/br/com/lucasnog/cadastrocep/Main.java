package br.com.lucasnog.cadastrocep;

import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.*;

import javax.swing.*;


public class Main {
    public static void main(String[] args){

        ICepService service = new CepMemoriaService();
        boolean continuar = true;
        IUIService userService = null;

        String userI = JOptionPane.showInputDialog(
                "Selecione uma opção:\n" +
                "1 - Modo grafico\n" +
                "2 - Modo console");

            if(Integer.parseInt(userI) == 1){
                userService = new UIGraficService();
            }else if(Integer.parseInt(userI) == 2){
                userService = new UITextService();
            }

        do{
            try{
                switch (userService.menuPrincipal()) {
                    case 1:
                        service.cadastrar(userService.cadastro());
                        break;
                    case 2:
                        userService.exibir(service.listar());
                        break;
                    case 3:
                        userService.exibir(service.obterPeloNumero(userService.entradaCep()));
                        break;
                    case 4:
                        service.atualizarPeloNumero(userService.entradaCep(), userService.opcaoModificar(), userService.novoNome());
                        break;
                    case 5:
                        service.deletar(userService.entradaCep());
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