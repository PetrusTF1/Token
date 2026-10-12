*Repositório: github.com/PetrusTF1/Token (branch main)*

## 1. Visão geral

O repositório **Token** contém o projeto **spring_security_jwt**, uma aplicação Java com **Spring Boot** voltada à demonstração de **autenticação e autorização com Spring Security e tokens JWT**. O nome do artefato e as dependências indicam uma API que protege seus endpoints exigindo um token JWT assinado.

> Nota: este documento foi montado a partir da estrutura do repositório e do arquivo `pom.xml`. O código-fonte dentro de `src` não pôde ser lido, então as seções de classes e endpoints estão listadas como pontos a completar.
> 

## 2. Identificação do projeto

| Item | Valor |
| --- | --- |
| groupId | br.com.petrusspring |
| artifactId | spring_security_jwt |
| Versão | 0.0.1-SNAPSHOT |
| Spring Boot | 4.1.1 |
| Java | 21 |
| Build | Maven (com Maven Wrapper) |

## 3. Tecnologias e dependências

- **spring-boot-starter-webmvc**: camada web e endpoints REST.
- **spring-boot-starter-security**: autenticação e autorização.
- **spring-boot-starter-security-oauth2-resource-server**: validação de tokens JWT como Resource Server.
- **spring-boot-starter-data-jdbc**: acesso a dados via Spring Data JDBC.
- **H2** (escopo runtime): banco de dados em memória para desenvolvimento e testes.
- **Dependências de teste**: starters de teste para web, security e JDBC.

## 4. Estrutura do repositório

| Item | Função |
| --- | --- |
| `src/` | Código-fonte e recursos da aplicação |
| `pom.xml` | Configuração do Maven e dependências |
| `mvnw` / `mvnw.cmd` / `.mvn/wrapper` | Maven Wrapper (Linux/macOS e Windows), dispensa instalar o Maven |
| `keypair.pem` | Arquivo de par de chaves usado com a assinatura/validação do JWT |
| `.gitignore` / `.gitattributes` | Configurações do Git |

## 5. Como funciona (arquitetura de segurança)

O fluxo típico de um projeto com este conjunto de dependências é:

1. O cliente se autentica (por exemplo, enviando usuário e senha a um endpoint de login).
2. A aplicação gera um **JWT assinado com a chave privada RSA**.
3. Nas requisições seguintes, o cliente envia o token no cabeçalho `Authorization: Bearer <token>`.
4. O **Resource Server** do Spring Security valida a assinatura com a **chave pública** e libera ou bloqueia o acesso ao endpoint.

O uso de um par de chaves RSA (privada para assinar, pública para validar) é o que justifica a presença do arquivo `keypair.pem` e das chaves `app.key` e `app.pub` em `src/main/resources`.

## 6. Como executar

Pré-requisito: **JDK 21**.

No Windows:

```
mvnw.cmd spring-boot:run
```

No Linux/macOS:

```
./mvnw spring-boot:run
```

Para gerar o pacote:

```
mvnw.cmd clean package
```

## 7. Pontos a completar com o código-fonte

- Lista de endpoints (login, rotas protegidas) e exemplos de requisição.
- Classe de configuração de segurança (`SecurityFilterChain`, regras de acesso).
- Geração e validação do JWT (claims, tempo de expiração).
- Modelo de usuários e tabelas no H2.

## 8. Observação sobre a chave

Como o projeto é apenas um gerador de token, isolado e sem integração com outros sistemas, o `keypair.pem` versionado não representa risco real. Se o projeto for integrado a algo no futuro, gere um novo par de chaves em vez de reutilizar este.

## 9. Resumo

O projeto é uma base enxuta para estudar **Spring Security com JWT** em Spring Boot 4.1.1 e Java 21, usando assinatura RSA, banco H2 e Maven Wrapper para execução simples no Windows e em outros sistemas.