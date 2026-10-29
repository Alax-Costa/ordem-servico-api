#Ordem de Serviço API

> API RESTful desenvolvida em Java e Spring Boot para gerenciamento e abertura de ordens de serviço (chamados técnicos) de Hardware e Software.

---

#Sobre o Projeto

Este projeto consiste em um sistema backend de **Gestão de Chamados/Ordens de Serviço**. Ele foi desenvolvido com o objetivo de demonstrar boas práticas de arquitetura de software, padrão DTO, polimorfismo, e tratamento global de exceções.

A API permite o cadastro de clientes e técnicos, além da abertura e consulta de chamados com tipagens específicas (Hardware e Software).

---

#Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
  - Spring Web (REST API)
  - Spring Data JPA (Persistência de Dados)
- **H2 Database** (Banco de dados em memória para testes/desenvolvimento)
- **Maven** (Gerenciamento de dependências)
- **Lombok** (Boilerplate code reduction)

---

#Arquitetura e Padrões de Projeto

O projeto adota o padrão de arquitetura em camadas (**MVC**):

- **Controller:** Exposição dos endpoints REST e manipulação de requisições/respostas HTTP.
- **Service:** Regras de negócio e validações da aplicação.
- **Repository:** Interface de comunicação com o banco de dados via Spring Data JPA.
- **DTO (Data Transfer Object):** Isolamento entre o modelo do banco de dados e a camada de apresentação.
- **Exception Handling:** Tratamento global e customizado de exceções (`@RestControllerAdvice`).
- **Polimorfismo / OO:** Estruturação da classe abstrata `Chamado` estendida por `ChamadoHardware` e `ChamadoSoftware`.

---

#Endpoints da API

Clientes (`/api/clientes`)
- `POST /api/clientes` - Cadastra um novo cliente.
- `GET /api/clientes` - Lista todos os clientes cadastrados.
- `GET /api/clientes/{id}` - Busca cliente por ID.

Chamados (`/api/chamados`)
- `POST /api/chamados/hardware` - Abre um chamado do tipo Hardware.
- `POST /api/chamados/software` - Abre um chamado do tipo Software.
- `GET /api/chamados` - Lista todos os chamados abertos.
- `GET /api/chamados/{id}` - Busca um chamado por ID.

---

#Como Executar o Projeto Localmente

Pré-requisitos
- **Java JDK 17** ou superior instalado.
- **Git** instalado.
- **IDE** de sua preferência (IntelliJ IDEA, Eclipse, VS Code).

#Passo a Passo

1. Clone o repositório:
   ```bash
   git clone [https://github.com/Alax-Costa/ordem-servico-api.git](https://github.com/Alax-Costa/ordem-servico-api.git)
