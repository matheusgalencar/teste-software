package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {
    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void deveCadastrarERecuperarProduto() {
        Long id = service.cadastrar("Teclado", 150.0).getId();
        assertNotNull(id);

        entityManager.flush();
        entityManager.clear();

        Produto recuperado = repository.findById(id).orElseThrow();
        assertEquals("Teclado", recuperado.getNome());
        assertEquals(150.0, recuperado.getPreco());
    }

    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        long quantidadeInicial = repository.count();

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar(" ", 80.0));

        assertEquals(quantidadeInicial, repository.count());
    }

    @Test
    void deveAtualizarPrecoPersistido() {
        Long id = service.cadastrar("Mouse", 80.0).getId();
        service.atualizarPreco(id, 95.0);

        entityManager.flush();
        entityManager.clear();

        Produto atualizado = repository.findById(id).orElseThrow();
        assertEquals(95.0, atualizado.getPreco());
    }
}
