# 📒 Spring Agenda de Contatos

Este projeto é uma aplicação de Agenda de Contatos desenvolvida com **Spring Boot**, utilizando boas práticas como separação de responsabilidades com **DTOs**, **Validação de Dados**, uso de **Lombok** para reduzir boilerplate e **Spring Data JPA** para persistência. A gestão do projeto foi feita com **Maven**.

> ⚠️ Este projeto será atualizado futuramente para utilizar o **ModelMapper** na conversão entre as Entidades e os DTOs.

---

## 🚀 Tecnologias Utilizadas

- ✅ **Java 17+**
- ✅ **Spring Boot**
- ✅ **Spring Data JPA**
- ✅ **Maven** (gerenciamento de dependências)
- ✅ **Lombok** (anotações para getters/setters, construtores e builders)
- ✅ **Jakarta Validation** (validação de dados de entrada)
- ✅ **H2 Database** (ou outro, conforme configuração)
- ✅ **DTO Pattern** (Data Transfer Object)
- 🚧 **ModelMapper** (em breve...)

---

## 🗂️ Estrutura do Projeto

- **model** → Entidade `Contact` mapeada com JPA.
- **dto** → `ContactRequestDTO` e `ContactResponseDTO` para manipular os dados de entrada e saída.
- **repository** → `ContactRepository` estende `JpaRepository` para simplificar o acesso ao banco.
- **service** → `ContactService` centraliza as regras de negócio e conversão entre entidade e DTO.
- **exception** → `ResourceNotFoundException` para tratamento de erro personalizado.
- **controller** → (em breve... caso você ainda não tenha criado).

---

## ✅ Funcionalidades

- ➕ Cadastrar um novo contato
- 🔍 Buscar contato por ID
- 📃 Listar todos os contatos
- ❌ Deletar contato por ID
- ❌ Deletar todos os contatos

---

## 🛠️ Como Executar o Projeto

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/spring-agenda-contatos.git
```

2. Acesse a pasta do projeto:

```bash
cd spring-agenda-contatos
```

3. Compile e execute o projeto:

```bash
./mvnw spring-boot:run
```

4. Acesse a aplicação via Postman, Insomnia ou qualquer cliente REST na porta padrão:

```bash
http://localhost:8080
```

## ✅ Próximas Melhorias

- ✅ Implementar o ModelMapper para automatizar a conversão entre DTOs e Entidades.
- ✅ Criar camada de Controller com endpoints REST.
- ✅ Implementar testes unitários e de integração.
- ✅ Adicionar documentação com Swagger/OpenAPI.
- ✅ Melhorar o tratamento de exceções.


## 💡 Motivação

Este projeto foi desenvolvido para praticar os seguintes conceitos:

- Estruturação de uma aplicação Spring Boot.
- Uso correto de DTOs para evitar o acoplamento direto com entidades.
- Aplicação de validação de dados com jakarta.validation.
- Boas práticas com Lombok.
- Separação das camadas de negócio.

## 📝 Licença

Este projeto está sob a licença MIT.




