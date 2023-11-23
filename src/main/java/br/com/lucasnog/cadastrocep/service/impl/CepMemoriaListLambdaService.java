package br.com.lucasnog.cadastrocep.service.impl;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.ICepService;

import java.util.Optional;

public class CepMemoriaListLambdaService extends CepMemoriaListAbstract implements ICepService {

    @Override
    public Optional<Cep> obterPeloNumero(Integer numeroCep) throws CepInvalidoException {
        var retorno = listaCep.stream()
                .filter(cepFound -> cepFound.getNumero().equals(numeroCep))
                .findFirst();
        retorno.orElseThrow(() -> new CepInvalidoException("Erro: Cep não encontrado no sistema."));
        return retorno;


    }


}
