package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.implementation.CepMemoriaListLambdaService;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CepMemoriaListLambdaServiceTest {


    @Test
    public void testCadastrar() throws CepInvalidoException {

        CepMemoriaListLambdaService cepService = new CepMemoriaListLambdaService();
        Integer cepTest = 74915430;
        Cep cep = new Cep(cepTest, "Rua Teste", "Cidade Teste", "Estado Teste");
        String resultado = cepService.cadastrar(cep);

        assertEquals(cepTest + " cadastrado com sucesso", resultado);

        assertThrows(CepInvalidoException.class, () -> cepService.cadastrar(cep));
    }


    @Test
    public void testObterPeloNumero() throws CepInvalidoException {

        CepMemoriaListLambdaService cepService = new CepMemoriaListLambdaService();
        Cep cepTeste = new Cep(74915430, "teste", "teste", "teste");
        cepService.cadastrar(cepTeste);

        Optional<Cep> teste = cepService.obterPeloNumero(74915430);
        assertEquals((Optional.of(cepTeste)), teste);


        Integer cepNaoExistente = 87654321;

        assertThrows(CepInvalidoException.class, () -> cepService.obterPeloNumero(cepNaoExistente));


    }

    @Test
    public void testListar() {
        CepMemoriaListLambdaService cepService = new CepMemoriaListLambdaService();

        List<Cep> resultado = cepService.listar();

        assertNotNull(resultado);

    }

    @Test
    public void testAtualizarPeloNumero() throws CepInvalidoException {

        CepMemoriaListLambdaService cepService = new CepMemoriaListLambdaService();
        Cep cep = new Cep(74915430, "test1", "test1", "teste1");

        cepService.cadastrar(cep);


        String mensagem = cepService.atualizarPeloNumero(cep.getNumero(), 1, "Nova Rua");
        assertEquals("Rua modificada com sucesso!", mensagem);

        mensagem = cepService.atualizarPeloNumero(cep.getNumero(), 2, "Nova Cidade");
        assertEquals("Cidade modificada com sucesso!", mensagem);

        mensagem = cepService.atualizarPeloNumero(cep.getNumero(), 3, "Nova Cidade");
        assertEquals("Estado modificado com sucesso!", mensagem);

        mensagem = cepService.atualizarPeloNumero(cep.getNumero(), 15, "Nova Cidade");
        assertEquals("Opção invalida", mensagem);

        assertThrows(CepInvalidoException.class, () -> cepService.atualizarPeloNumero(74747474, 1, "a"));


    }

    @Test
    public void testDelete() throws CepInvalidoException {

        CepMemoriaListLambdaService cepService = new CepMemoriaListLambdaService();
        Cep cep = new Cep(74915430, "test1", "test1", "teste1");

        cepService.cadastrar(cep);


        String mensagem = cepService.deletar(cep.getNumero());
        assertEquals("Cep " + cep.getNumero() + " removido com sucesso.", mensagem);

        assertThrows(CepInvalidoException.class, () -> cepService.deletar(7474744));
    }


}
