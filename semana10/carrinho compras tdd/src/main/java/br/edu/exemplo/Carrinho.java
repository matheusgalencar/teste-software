package br.edu.exemplo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static final BigDecimal LIMITE_DESCONTO = new BigDecimal("500.00");
    private static final BigDecimal FATOR_COM_DESCONTO = new BigDecimal("0.90");

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            subtotal = subtotal.add(BigDecimal.valueOf(produto.getPreco()));
        }
        if (subtotal.compareTo(LIMITE_DESCONTO) >= 0) {
            subtotal = subtotal.multiply(FATOR_COM_DESCONTO);
        }
        return subtotal.doubleValue();
    }
}
