package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.Map;

public interface IUIService {
    public Integer menuPrincipal();
    public Cep cadastro() throws CepInvalidoException;
    public Integer entradaCep();
    public Integer opcaoModificar();

    public String novoNome();

    public <T> void exibir(T msg);
}
