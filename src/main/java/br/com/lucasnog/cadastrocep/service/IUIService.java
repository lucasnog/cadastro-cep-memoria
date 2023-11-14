package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

public interface IUIService {
     Integer menuPrincipal();
     Cep cadastro() throws CepInvalidoException;
     Integer entradaCep();
     Integer opcaoModificar();

     String novoNome();

     <T> void exibir(T msg);
}
