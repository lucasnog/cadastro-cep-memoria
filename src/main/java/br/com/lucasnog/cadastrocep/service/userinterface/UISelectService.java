package br.com.lucasnog.cadastrocep.service.userinterface;

import br.com.lucasnog.cadastrocep.service.IUIService;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class UISelectService {
    static Scanner sc = new Scanner(System.in);

    public static IUIService selectMode() {
        String continuar = "sim";
        while (continuar.equals("sim")) {
            System.out.println("Bem vindo ao sistema de cadastro de CEP!");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Modo console");
            System.out.println("2 - Modo grafico");

            Integer userI = sc.nextInt();

            try {
                if (userI == 1) {
                    continuar = "não";
                    return new UIConsoleService();
                } else if (userI == 2) {
                    sc.close();
                    continuar = "não";
                    return new UIGraficService();
                } else {
                    System.out.println("Digite umaopção valida.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Digite uma opção valida.");
            }

        }
        return null;
    }
}
