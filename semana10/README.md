# Avaliação prática — Prova 02

**Dupla:** Matheus Goulart de Alencar e Miguel Falcão Costacurta.

## Semana 10 — TDD

Cada exercício em `semana10/` tem seu próprio `pom.xml`, código em `src/main/java` e testes em `src/test/java`. Os projetos seguem a estrutura dos arquivos da disciplina e usam Maven e JUnit 5, com compilação para Java 17.

| Projeto | Requisitos atendidos | Testes | Cobertura de linhas | Cobertura de decisões |
|---|---|---:|---:|---:|
| Bubble Sort | Ordenação crescente de vetor desordenado, ordenado e com repetidos | 3 | 11/11 (100%) | 6/6 (100%) |
| Carrinho de Compras | Carrinho vazio, adição, soma, remoção, preço negativo e desconto a partir de R$ 500 | 11 | 23/23 (100%) | 6/6 (100%) |
| Conta Bancária | Depósito, depósitos acumulados, saque e saque acima do saldo | 4 | 9/9 (100%) | 2/2 (100%) |
| Estoque | Estoque inicial, entradas acumuladas, retirada e operações inválidas | 8 | 12/12 (100%) | 6/6 (100%) |

A execução de `mvn clean verify` nos quatro projetos concluiu com 26 testes aprovados, sem falhas ou testes ignorados. A cobertura foi medida pelo JaCoCo.
### Como reproduzir

Execute em cada pasta de `semana10/`:

```bash
mvn clean verify
```

O comando recompila o projeto, executa os testes e gera o relatório JaCoCo em `target/site/jacoco/index.html`.
