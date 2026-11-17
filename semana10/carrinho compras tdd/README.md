# Carrinho de Compras — TDD

**Dupla:** Matheus Goulart de Alencar e Miguel Falcão Costacurta.

Projeto Maven para prática de TDD com Java 17 e JUnit 5.

## Executar os testes

```bash
mvn clean verify
```

## Atividade

Os testes verificam carrinho vazio, adição e remoção de produtos, soma dos preços e desconto de 10% a partir de R$ 500,00. O construtor de `Produto` lança `IllegalArgumentException` para preço negativo.

O relatório de cobertura é gerado em `target/site/jacoco/index.html`.
