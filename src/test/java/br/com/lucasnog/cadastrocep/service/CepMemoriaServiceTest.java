package br.com.lucasnog.cadastrocep.service;

import br.com.lucasnog.cadastrocep.domain.Cep;
import br.com.lucasnog.cadastrocep.exception.CepInvalidoException;
import br.com.lucasnog.cadastrocep.service.CepMemoriaService;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CepMemoriaServiceTest {
    @Test
    public void testCadastrarNovoCep() throws CepInvalidoException {

        CepMemoriaService cepService = new CepMemoriaService();
        Cep cep = new Cep(74915430, "Rua Teste", "Cidade Teste", "Estado Teste");
        String resultado = cepService.cadastrar(cep);

        // Verifica se a mensagem de sucesso está correta
        assertEquals("74915430 cadastrado com sucesso", resultado);

        // Verifica se o Cep foi adicionado corretamente à lista interna
        assertTrue(cepService.listar().containsKey(74915430));
    }

    @Test
    public void testCadastrarCepExistente() {

        CepMemoriaService cepService = new CepMemoriaService();
        Cep cep = new Cep(74915430, "Rua Teste", "Cidade Teste", "Estado Teste");

        // Adiciona o Cep manualmente à lista interna
        cepService.listar().put(74915430, cep);

        // Tenta cadastrar o mesmo Cep novamente e verifica se a exceção é lançada
        assertThrows(CepInvalidoException.class, () -> cepService.cadastrar(cep));
    }


    @Test
    public void testObterPeloNumero_CepNaoExistente() {
        // Crie uma instância da sua classe de serviço CepMemoriaService
        CepMemoriaService cepService = new CepMemoriaService();

        // Adicione alguns dados de exemplo ao seu serviço (se necessário)

        // Especifique um número de CEP que não existe
        Integer cepNaoExistente = 87654321;

        // Chame o método obterPeloNumero com o número de CEP não existente e capture a exceção
        assertThrows(CepInvalidoException.class, () -> cepService.obterPeloNumero(cepNaoExistente));

    }

    @Test
    public void testListar() {
        // Crie uma instância da sua classe de serviço CepMemoriaService
        CepMemoriaService cepService = new CepMemoriaService();

        // Adicione alguns dados de exemplo ao seu serviço (se necessário)

        // Chame o método listar e obtenha o resultado
        Map<Integer, Cep> resultado = cepService.listar();

        // Realize as asserções com base no que você espera que o método listar retorne
        assertNotNull(resultado);

    }

    @Test
    public void testAtualizarPeloNumero_Rua() throws CepInvalidoException {

        CepMemoriaService cepService = new CepMemoriaService();
        Cep cep = new Cep(74915430, "test1", "test1", "teste1");

        cepService.cadastrar(cep);

        // Chame o método atualizarPeloNumero para modificar a rua
        String mensagem = cepService.atualizarPeloNumero(cep.getNumero(), 1, "Nova Rua");

        // Realize as asserções com base no que você espera que o método retorne para a modificação da rua
        assertEquals("Rua modificada com sucesso!", mensagem);

    }



}
