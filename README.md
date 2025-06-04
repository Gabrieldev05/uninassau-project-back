# BackPro

## Descrição
BackPro é um sistema desenvolvido em **Java** utilizando o framework **Spring Boot** para gerenciar entidades como **Aluno**, **Professor** e **Turma**. O projeto utiliza **PostgreSQL** como banco de dados e segue boas práticas de desenvolvimento, incluindo mapeamento de entidades para DTOs e testes unitários com **JUnit** e **Mockito**.

---

## Tecnologias Utilizadas
- **Java** (versão 17 ou superior)
- **Spring Boot**
- **Maven** (gerenciador de dependências)
- **PostgreSQL** (banco de dados relacional)
- **JUnit** e **Mockito** (testes unitários)
- **Lombok** (para reduzir boilerplate de código)

---

## Configuração do Banco de Dados
Certifique-se de que o PostgreSQL esteja instalado e configurado corretamente. As configurações do banco de dados estão no arquivo `src/main/resources/application.properties`:

## ini
spring.datasource.url=jdbc:postgresql://localhost:5432/uninassau
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true

## Passos para Configuração:
Crie um banco de dados chamado uninassau.
Atualize o username e password no arquivo application.properties conforme suas credenciais do PostgreSQL.

<hr></hr>

## Estrutura do Projeto
### src/main/java/com/uninassau/backpro:
model: Contém as entidades do sistema (Aluno, Professor, Turma, etc.).
dto: Contém os Data Transfer Objects (DTOs) para comunicação entre camadas.
mapper: Contém os mapeadores para conversão entre entidades e DTOs.
services: Contém a lógica de negócios.
repositories: Contém as interfaces para acesso ao banco de dados.
exceptions: Contém classes para tratamento de erros personalizados.
request/controller: Contém os controladores REST para exposição de APIs.

### src/test/java/com/uninassau/backpro:
Contém os testes unitários para as classes do projeto.

<hr></hr>

## Executando o Projeto
Pré-requisitos:
Java 17 ou superior instalado.
Maven instalado.
PostgreSQL configurado.

Passos:
Clone o repositório:
git clone https://github.com/Gabrieldev05/uninassau-project-back.git
Navegue até o diretório do projeto:
cd backpro
Compile e execute o projeto:
mvn spring-boot:run

