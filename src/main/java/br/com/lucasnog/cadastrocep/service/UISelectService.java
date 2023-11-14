package br.com.lucasnog.cadastrocep.service;

import javax.swing.*;
import java.text.NumberFormat;

public class UISelectService {

    public static IUIService selectMode(){
        String continuar = "sim";
        while (continuar.equals("sim")) {
           String userI = JOptionPane.showInputDialog(
                    "Selecione uma opção:\n" +
                            "1 - Modo grafico\n" +
                            "2 - Modo console");
            try {
                if(Integer.parseInt(userI) == 1){
                    continuar = "não";
                    return new UIGraficService();
                }else if(Integer.parseInt(userI) == 2){
                    continuar = "não";
                    return new UIConsoleService();
                }else{
                    JOptionPane.showMessageDialog(null, "Digite uma opção valida.");
                }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido.");
            }

        }


        return null;
    }
}
