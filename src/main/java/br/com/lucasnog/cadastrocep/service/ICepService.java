package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.Map;
import java.util.Optional;

public interface ICepService {
    void cadastrar(Integer cep);
    Map<Integer,Cep> listar();
    Optional<Cep> obterPeloNumero(Integer cep);
    void atualizarPeloNumero(Integer cep, Integer op);
    void deletar(Integer cep);
    boolean checkExiste(Integer cep) throws CepInvalidoException;
}
