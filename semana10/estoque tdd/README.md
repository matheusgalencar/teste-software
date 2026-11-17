# Estoque — Exemplo de TDD

**Dupla:** Matheus Goulart de Alencar e Miguel Falcão Costacurta.

Projeto Maven com Java 17 e JUnit 5 para demonstração de TDD.

## Executar

```bash
mvn clean verify
```

## Casos de teste

1. Produto inicia com estoque zero.
2. Adicionar unidades ao estoque.
3. Acumular várias entradas.
4. Retirar unidades do estoque.
5. Não permitir retirada maior que o estoque disponível.
6. Manter o estoque ao tentar adicionar zero ou uma quantidade negativa.
7. Manter o estoque ao tentar retirar uma quantidade negativa.

O relatório de cobertura é gerado em `target/site/jacoco/index.html`.
