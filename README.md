# 📒 Spring Agenda de Contatos

Este projeto é uma aplicação de **Agenda de Contatos** desenvolvida com **Spring Boot**, seguindo boas práticas de desenvolvimento como separação em camadas, uso de **DTOs**, **validação com Jakarta Validation**, **tratamento de exceções customizadas** e integração com banco de dados via **Spring Data JPA**.

> ⚠️ Este projeto será **futuramente atualizado** para utilizar **ModelMapper** na conversão entre entidades e DTOs, melhorando a legibilidade e manutenção do código.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Data JPA
- ✅ Lombok
- ✅ Jakarta Validation
- ✅ Maven
- ✅ MySQL (ou H2, configurável)
- 🚧 ModelMapper (em breve...)

---

## 🗂️ Estrutura do Projeto

com.demo.spring_agenda
 ├── controller          # Endpoints REST
 ├── dto
 │   ├── request         # DTOs de entrada
 │   └── response        # DTOs de saída
 ├── exception           # Classes de exceções personalizadas
 ├── model               # Entidades JPA: Contato, Endereco
 ├── repository          # Interfaces que estendem JpaRepository
 └── service             # Regras de negócio e conversões DTO ↔ Entidade



---

## ✅ Funcionalidades

### 📇 Endereços
- ➕ Cadastrar um endereço
- 🔍 Buscar endereço por ID
- 📃 Listar todos os endereços
- ✏️ Atualizar endereço por ID
- ❌ Deletar endereço por ID
- ❌ Deletar todos os endereços

### 👤 Contatos
- ➕ Cadastrar um contato vinculado a um endereço existente
- 🔍 Buscar contato por ID
- 📃 Listar todos os contatos
- ✏️ Atualizar contato por ID
- ❌ Deletar contato por ID
- ❌ Deletar todos os contatos

---

## 📦 Exemplo de Requisições (Postman)

### 🔸 Cadastrar Endereço

**Endpoint:** `POST /api/enderecos`

```json
{
  "rua": "Rua José",
  "numero": "99",
  "bairro": "Teste",
  "cidade": "Valinhos",
  "estado": "SP",
  "cep": "99999-999",
  "pais": "Brasil"
}
```

🖼️ **Exemplo no Postman:**



### 🛢️ Visualização no Banco de Dados

🖼️ **Tabela `endereco`:**



🖼️ **Tabela `contato`:**



**🛠️ Como Executar o Projeto**



1. Clone o repositório:

   ```
   git clone https://github.com/seu-usuario/spring-agenda-contatos.git
   
   ```



2. Acesse a pasta do projeto:

   ```
   cd spring-agenda-contatos
   ```

   

3. Configure o `application.properties` para apontar para o seu banco de dados:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/agenda_contatos
   spring.datasource.username=root
   spring.datasource.password=suasenha
   spring.jpa.hibernate.ddl-auto=update
   
   ```

   

4. Execute o projeto:

   ```
   ./mvnw spring-boot:run
   ```

   

   5. Acesse via Postman ou navegador:

      ```
      http://localhost:8080
      ```



📈 Próximas Melhorias



✅ Substituir métodos de conversão manual por **ModelMapper**

✅ Adicionar Swagger para documentação da API

✅ Criar testes unitários e de integração

✅ Melhorar a cobertura de exceções com `@ControllerAdvice`

✅ Implementar autenticação com Spring Security (futuramente)



💡 Motivação



Este projeto foi criado com o objetivo de:

- Consolidar conhecimentos em Spring Boot.
- Praticar o uso de DTOs e boas práticas REST.
- Aprender validação de dados e tratamento de exceções.
- Organizar a estrutura do projeto em camadas bem definidas.
