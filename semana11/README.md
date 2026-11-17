# Semana 11 — Testes de integração com Spring Boot

**Dupla:** Matheus Goulart de Alencar e Miguel Falcão Costacurta.

Projeto Maven para Java 17 com Spring Boot, Spring Data JPA, H2, JUnit 5 e MockMvc. 

## Casos de teste

| Caso | Verificação |
|---|---|
| CT01 — Cadastro válido | Cadastra Teclado por 150,00, confirma a geração do ID e consulta nome e preço no repositório. |
| CT02 — Nome em branco | Tenta cadastrar um produto por 80,00, verifica a exceção `IllegalArgumentException` e confirma que a contagem permanece igual. |
| CT03 — Atualização (desafio) | Cadastra Mouse por 80,00, altera o preço para 95,00 e confere o valor em uma nova consulta. |
| CT04 — Cadastro pela API | Envia Mouse por 80,00 via `POST /produtos` e verifica HTTP 200, ID numérico, nome e preço no JSON. |
| CT05 — Consulta pela API | Obtém com `ObjectMapper` o ID retornado pelo POST, envia `GET /produtos/{id}` e confere HTTP 200 e os dados cadastrados. |

## Persistência e isolamento

CT01 e CT03 chamam `flush()` para enviar as alterações ao banco e `clear()` para limpar o contexto de persistência antes de consultar por ID. Isso permite verificar o registro no H2 mesmo quando o serviço já retornou um objeto com os dados esperados. CT05 usa o mesmo procedimento entre o POST e o GET.

`@Transactional` abre uma transação para cada teste e o Spring a desfaz ao final. Assim, os registros criados por um caso não afetam os outros.

O MockMvc encaminha as requisições ao `DispatcherServlet` dentro do processo de teste. O fluxo passa pelo controller, pelo serviço, pelo repositório JPA e pelo H2. Um teste unitário isolaria o controller e verificaria somente o comportamento desse componente.

## Execução

Na pasta deste projeto, execute:

```bash
mvn clean test
```

Resultado de `mvn clean test`: 5 testes aprovados, com 0 falhas, 0 erros e 0 ignorados.

| Classe | Testes aprovados |
|---|---:|
| `ProdutoServiceIntegrationTest` | 3 |
| `ProdutoControllerIntegrationTest` | 2 |

Os relatórios por classe são gerados em `target/surefire-reports/`.
