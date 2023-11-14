package br.com.lucasnog.cadastrocep.service;
import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.*;

public class CepMemoriaService implements ICepService {
    private Map<Integer, Cep> listaCep = new HashMap<>();


    @Override
    public String cadastrar(Cep cep) throws CepInvalidoException {
        if(listaCep.containsKey(cep.getNumero())){
            throw new CepInvalidoException("Erro: Cep já existe no sistema.");
        }

        Cep cepObj = new Cep(cep.getNumero(), cep.getRua(), cep.getCidade(), cep.getEstado());
        listaCep.put(cepObj.getNumero(), cepObj);
        return cepObj.getNumero().toString() + " cadastrado com sucesso";

    }

    @Override
    public Map<Integer, Cep> listar() {
        return listaCep;
    }

    @Override
    public Optional<Cep> obterPeloNumero(Integer cep) throws CepInvalidoException {
        if(listaCep.containsKey(cep)) {
            return Optional.ofNullable(listaCep.get(cep));
        }else{
            throw new CepInvalidoException("CEP não encontrado no sistema.");
        }
    }

    @Override
    public String atualizarPeloNumero(Integer cep, Integer op, String novo ) throws CepInvalidoException {
        if (!listaCep.containsKey(cep)){
            throw new CepInvalidoException("CEP não encontrado no sistema.");
        }
        switch (op) {
            case 1:
                listaCep.get(cep).setRua(novo);
                return "Rua modificada com sucesso!";

            case 2:
                listaCep.get(cep).setCidade(novo);
                return "Cidade modificada com sucesso!";

            case 3:
                listaCep.get(cep).setEstado(novo);
                return "Estado modificado com sucesso!";

            default:
                return "Opção invalida";
        }
    }

    @Override
    public String deletar(Integer cep) throws CepInvalidoException{
        if(listaCep.containsKey(cep)) {
            listaCep.remove(cep);
            return "Cep " + cep + " removido com sucesso.";
        }else{
            throw new CepInvalidoException("CEP não encontrado no sistema.");
        }
    }

}
