# Carrinho de Compras — Prática de TDD

## Classes iniciais

O projeto possui inicialmente:

- `Produto`: representa um produto com nome e preço.
- `Carrinho`: classe que deverá ser desenvolvida durante a atividade.
- `CarrinhoTest`: classe onde deverão ser escritos os testes.

A relação esperada será:

```text
Carrinho ──────> Produto
```

O carrinho deverá armazenar e manipular objetos do tipo `Produto`.

---

# Como trabalhar cada requisito

Para **cada requisito**, siga obrigatoriamente o ciclo:

```text
REQUISITO
    ↓
ESCREVER O TESTE
    ↓
EXECUTAR
    ↓
RED
    ↓
IMPLEMENTAR O MÍNIMO NECESSÁRIO
    ↓
EXECUTAR
    ↓
GREEN
    ↓
REFACTOR
    ↓
PRÓXIMO REQUISITO
```

---

# Requisito 1 — Carrinho vazio

Um carrinho recém-criado deve possuir **valor total igual a R$ 0,00**.

---

# Requisito 2 — Adicionar um produto

O carrinho deve permitir adicionar um produto.

Exemplo de comportamento esperado:

```text
Produto: Teclado
Preço: R$ 100,00

Total esperado do carrinho: R$ 100,00
```

---

# Requisito 3 — Adicionar vários produtos

O carrinho deve permitir adicionar vários produtos e calcular corretamente
a soma de seus preços.

Exemplo:

```text
Teclado ........ R$ 100,00
Mouse .......... R$  50,00
---------------------------
Total .......... R$ 150,00
```

---

# Requisito 4 — Remover produto

Um produto adicionado ao carrinho deve poder ser removido.

Exemplo:

```text
Carrinho inicial:

Teclado ........ R$ 100,00
Mouse .......... R$  50,00
Total .......... R$ 150,00

Remover: Mouse

Total esperado: R$ 100,00
```

---

# Requisito 5 — Produto com preço inválido

Produtos com **preço negativo** não devem ser permitidos.

Exemplo inválido:

```text
Produto: Teclado
Preço: R$ -100,00
```

---

# Requisito 6 — Desconto

Compras cujo valor total seja **igual ou superior a R$ 500,00** devem receber
**10% de desconto**.

Exemplo:

```text
Subtotal ........ R$ 600,00
Desconto (10%) .. R$  60,00
----------------------------
Total ........... R$ 540,00
```

Considere também testar valores próximos à fronteira:

```text
R$ 499,99
R$ 500,00
R$ 500,01
```

---