package br.com.lucasnog.cadastrocep.service.implementation;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CepMemoriaListAbstract implements ICepService {

    protected List<Cep> listaCep = new ArrayList<>();

    public abstract Optional<Cep> obterPeloNumero(Integer numeroCep) throws CepInvalidoException;


    public String cadastrar(Cep cep) throws CepInvalidoException {
        if (listaCep.contains(cep)) {
            throw new CepInvalidoException("Erro: Cep já existe no sistema.");
        }

        listaCep.add(cep);
        return cep.getNumero() + " cadastrado com sucesso";
    }


    public List<Cep> listar() {

        return listaCep;
    }


    public String atualizarPeloNumero(Integer cep, Integer op, String novo) throws CepInvalidoException {

        if (obterPeloNumero(cep).isPresent()) {

            switch (op) {
                case 1:
                    obterPeloNumero(cep).get().setRua(novo);
                    return "Rua modificada com sucesso!";

                case 2:
                    obterPeloNumero(cep).get().setCidade(novo);
                    return "Cidade modificada com sucesso!";

                case 3:
                    obterPeloNumero(cep).get().setEstado(novo);
                    return "Estado modificado com sucesso!";

                default:
                    return "Opção invalida";
            }
        }

        return null;
    }


    public String deletar(Integer cep) throws CepInvalidoException {
        if (obterPeloNumero(cep).isPresent()) {
            listaCep.remove(obterPeloNumero(cep).get());
            return "Cep " + cep + " removido com sucesso.";
        } else {
            throw new CepInvalidoException("Erro: Cep não encontrado no sistema.");
        }
    }
}
