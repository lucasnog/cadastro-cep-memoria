package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.Map;
import java.util.Optional;

public interface ICepService {
    void cadastrar(Cep cep) throws CepInvalidoException;
    Map<Integer,Cep> listar();
    Optional<Cep> obterPeloNumero(Integer cep) throws CepInvalidoException;
    void atualizarPeloNumero(Integer cep, Integer op,String novo) throws CepInvalidoException;
    void deletar(Integer cep) throws CepInvalidoException;
}
