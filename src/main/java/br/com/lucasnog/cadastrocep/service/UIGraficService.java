package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import javax.swing.*;

public class UIGraficService implements IUIService {
    Integer cepNumero;

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public Integer menuPrincipal() {
        String op = JOptionPane.showInputDialog(
                "- Sistema de cadastro de CEP -" +
                "Escolha uma opção:\n" +
                        "1 - Cadastrar novo CEP\n" +
                        "2 - Listar todos os CEPs\n" +
                        "3 - Buscar CEP\n" +
                        "4 - Modificar CEP\n" +
                        "5 - Excluir CEP\n" +
                        "6 - Sair");

        return this.convertToInt(op);

    }

    @Override
    public Cep cadastro() throws CepInvalidoException {
        cepNumero = entradaCep();


        if (cepNumero.toString().length() != 8) {
            throw new CepInvalidoException("Número de digitos inválido.");
        }

        String rua = JOptionPane.showInputDialog("Digite o nome da rua:\n");
        String cidade = JOptionPane.showInputDialog("Digite o nome da cidade:\n");
        String estado = JOptionPane.showInputDialog("Digite o nome do estado:\n");

        return new Cep(cepNumero, rua, cidade, estado);

    }

    @Override
    public Integer entradaCep() {
        return this.convertToInt(JOptionPane.showInputDialog("Digite o numero do CEP:"));
    }

    @Override
    public Integer opcaoModificar() {
        return this.convertToInt(JOptionPane.showInputDialog(
                "O que deseja alterar?\n" +
                        "1 - rua\n" +
                        "2 - cidade\n" +
                        "3 - estado\n"));
    }

    @Override
    public String novoNome() {
        return JOptionPane.showInputDialog("Alterar para:");
    }

    @Override
    public <T> void exibir(T msg) {
        JOptionPane.showMessageDialog(null, msg.toString());

    }
}
