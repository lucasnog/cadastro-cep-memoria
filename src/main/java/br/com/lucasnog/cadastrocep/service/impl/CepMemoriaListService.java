package br.com.lucasnog.cadastrocep.service.impl;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.ICepService;

import java.util.Optional;

public class CepMemoriaListService extends CepMemoriaListAbstract implements ICepService {


    @Override
    public Optional<Cep> obterPeloNumero(Integer numeroCep) throws CepInvalidoException {

        for (Cep cep : listaCep) {
            if (cep.getNumero().equals(numeroCep)) {
                return Optional.ofNullable(cep);
            }
        }
        throw new CepInvalidoException("Error: Cep não encontado no sistema.");
    }

}

