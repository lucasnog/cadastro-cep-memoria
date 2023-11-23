package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.Optional;

public interface ICepService {
    String cadastrar(Cep cep) throws CepInvalidoException;

    <T> T listar();

    Optional<Cep> obterPeloNumero(Integer cep) throws CepInvalidoException;

    String atualizarPeloNumero(Integer cep, Integer op, String novo) throws CepInvalidoException;

    String deletar(Integer cep) throws CepInvalidoException;
}
