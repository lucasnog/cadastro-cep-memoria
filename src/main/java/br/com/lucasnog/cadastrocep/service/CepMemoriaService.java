package br.com.lucasnog.cadastrocep.service;
import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.*;

public class CepMemoriaService implements ICepService {
    Map<Integer, Cep> listaCep = new HashMap<>();


    @Override
    public void cadastrar(Cep cep) throws CepInvalidoException {
        if(listaCep.containsKey(cep.getNumero())){
            throw new CepInvalidoException("Erro: Cep já existe no sistema.");
        }

        Cep cepObj = new Cep(cep.getNumero(), cep.getRua(), cep.getCidade(), cep.getEstado());
        listaCep.put(cepObj.getNumero(), cepObj);
        System.out.println("CEP Cadastrado com sucesso.");
    }

    @Override
    public Map<Integer, Cep> listar() {
        System.out.println("Os CEPs cadastrados são:");
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
    public void atualizarPeloNumero(Integer cep, Integer op, String novo ) throws CepInvalidoException {
        if (!listaCep.containsKey(cep)){
            throw new CepInvalidoException("CEP não encontrado no sistema.");
        }
        switch (op) {
            case 1:
                listaCep.get(cep).setRua(novo);
                System.out.println("Modificado com sucesso!");
                break;
            case 2:
                listaCep.get(cep).setCidade(novo);
                System.out.println("Modificado com sucesso!");
                break;
            case 3:
                listaCep.get(cep).setEstado(novo);
                System.out.println("Modificado com sucesso!");
                break;
            default:
                System.out.println("Opção invalida.");
        }
    }

    @Override
    public void deletar(Integer cep) throws CepInvalidoException{
        if(listaCep.containsKey(cep)) {
            System.out.println("Cep " + cep + " foi removido com sucesso.");
            listaCep.remove(cep);
        }else{
            throw new CepInvalidoException("CEP não encontrado no sistema.");
        }
    }

}
