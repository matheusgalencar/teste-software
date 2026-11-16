package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {
    @Test
    void carrinhoVazioTemTotalZero() {
        assertEquals(0.0, new Carrinho().getTotal(), 0.001);
    }

    @Test
    void adicionaUmProduto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 100.0));
        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void somaVariosProdutos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 100.0));
        carrinho.adicionarProduto(new Produto("Mouse", 50.0));
        assertEquals(150.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void removeProdutoAdicionado() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.0);
        Produto mouse = new Produto("Mouse", 50.0);
        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(mouse);
        carrinho.removerProduto(mouse);
        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void rejeitaProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("Teclado", -100.0));
    }

    @Test
    void produtoMantemONomeInformado() {
        assertEquals("Teclado", new Produto("Teclado", 100.0).getNome());
    }

    @Test
    void naoAplicaDescontoAbaixoDeQuinhentos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Fone", 499.99));
        assertEquals(499.99, carrinho.getTotal(), 0.001);
    }

    @Test
    void aplicaDescontoNoLimiteDeQuinhentos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Fone", 500.0));
        assertEquals(450.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void aplicaDescontoAcimaDeQuinhentos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Fone", 500.01));
        assertEquals(450.009, carrinho.getTotal(), 0.001);
    }

    @Test
    void descontoConsideraSomaDosProdutos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 350.0));
        carrinho.adicionarProduto(new Produto("Mouse", 250.0));
        assertEquals(540.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void aplicaDescontoQuandoSomaComCentavosAtingeQuinhentos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 372.03));
        carrinho.adicionarProduto(new Produto("Adaptador", 0.01));
        carrinho.adicionarProduto(new Produto("Mouse", 127.96));
        assertEquals(450.0, carrinho.getTotal(), 0.001);
    }
}
