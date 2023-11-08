package br.com.lucasnog.cadastrocep.service;
import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;

import java.util.*;

public class CepMemoriaService implements ICepService {
    Scanner sc = new Scanner(System.in);
    String rua, cidade, estado;
    Map<Integer, Cep> listaCep = new HashMap<>();


    @Override
    public void cadastrar(Integer cep) {
        System.out.println("Digite o nome da rua:");
        rua = sc.nextLine();

        System.out.println("Digite o nome da cidade:");
        cidade = sc.nextLine();

        System.out.println("Digite o nome do estado:");
        estado = sc.nextLine();

        Cep cepObj = new Cep(cep, rua, cidade, estado);
        listaCep.put(cepObj.getNumero(), cepObj);
    }

    @Override
    public Map<Integer, Cep> listar() {
        System.out.println("Os CEPs cadastrados são:");
        return listaCep;
    }

    @Override
    public Optional<Cep> obterPeloNumero(Integer cep){
        return Optional.of(listaCep.get(cep));
    }

    @Override
    public void atualizarPeloNumero(Integer cep, Integer op) {
        switch (op) {
            case 1:
                System.out.println("Entre com o novo nome da rua:");
                rua = sc.nextLine();
                listaCep.get(cep).setRua(rua);
                System.out.println("Modificado com sucesso!");
                break;
            case 2:
                System.out.println("Entre com o novo nome da cidade:");
                cidade = sc.nextLine();
                listaCep.get(cep).setCidade(cidade);
                System.out.println("Modificado com sucesso!");
                break;
            case 3:
                System.out.println("Entre com o novo nome do estado:");
                estado = sc.nextLine();
                listaCep.get(cep).setEstado(estado);
                System.out.println("Modificado com sucesso!");
                break;
            default:
                System.out.println("Opção invalida.");
        }
    }

    @Override
    public void deletar(Integer cep) {
        System.out.println("Cep " + cep + " foi removido com sucesso.");
        listaCep.remove(cep);
    }

    @Override
    public boolean checkExiste(Integer cep) throws CepInvalidoException {
       return listaCep.containsKey(cep);
    }
}
