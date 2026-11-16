# Avaliação prática — Prova 02

Este projeto reúne as atividades por semana. A Semana 10 está concluída em `semana10/`.

## Semana 10 — TDD

Os quatro projetos foram copiados dos [arquivos da disciplina](https://github.com/JoaoChoma/teste_software_2026/tree/main/aulas/SEMANA10) e mantêm os enunciados originais. Cada projeto usa Java 17, Maven e JUnit 5. Os testes existentes de Bubble Sort, Conta Bancária e Estoque foram preservados; foram adicionados testes para o Carrinho e para a fronteira de quantidade zero no Estoque.

| Projeto | Requisitos atendidos | Testes | Cobertura de linhas | Cobertura de decisões |
|---|---|---:|---:|---:|
| Bubble Sort | Ordenação crescente de vetor desordenado, ordenado e com repetidos | 3 | 11/11 (100%) | 6/6 (100%) |
| Carrinho de Compras | Carrinho vazio, adição, soma, remoção, preço negativo e desconto a partir de R$ 500 | 10 | 19/19 (100%) | 6/6 (100%) |
| Conta Bancária | Depósito, depósitos acumulados, saque e saque acima do saldo | 4 | 9/9 (100%) | 2/2 (100%) |
| Estoque | Estoque inicial, entradas acumuladas, retirada e operações inválidas | 8 | 12/12 (100%) | 6/6 (100%) |

Os testes iniciais falharam como esperado nos projetos Bubble Sort, Conta Bancária e Estoque. O Carrinho inicialmente não tinha testes; após escrever os testes, a compilação falhou por falta dos métodos especificados. Após as implementações, `mvn verify` passou nos quatro projetos e o JaCoCo confirmou 100% de linhas e decisões em cada um.

O requisito de preço negativo do Carrinho permite discutir duas alternativas com o professor. Foi escolhida `IllegalArgumentException` no construtor de `Produto`, com teste correspondente.

### Como reproduzir

Execute em cada pasta de `semana10/`:

```bash
mvn verify
```

O comando executa os testes, gera o relatório JaCoCo em `target/site/jacoco/index.html` e falha se a cobertura de linhas ou decisões ficar abaixo de 100%. `mvn test` executa apenas os testes.
