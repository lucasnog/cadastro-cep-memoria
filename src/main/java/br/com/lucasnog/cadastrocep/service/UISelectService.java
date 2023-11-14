package br.com.lucasnog.cadastrocep.service;

import javax.swing.*;

public class UISelectService {

    public static IUIService selectMode(){

        String userI = JOptionPane.showInputDialog(
                "Selecione uma opção:\n" +
                        "1 - Modo grafico\n" +
                        "2 - Modo console");

        if(Integer.parseInt(userI) == 1){
            return new UIGraficService();
        }else if(Integer.parseInt(userI) == 2){
            return new UIConsoleService();
        }
        return null;
    }
}
