# 💸 Transação API

Sistema de gerenciamento de contas e transações financeiras, desenvolvido com Spring Boot e JPA. Permite o cadastro de usuários, criação de contas vinculadas, consulta de saldo e operações como depósito e transferência.

## 📦 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- Hibernate
- MySQL
- Lombok

## 🧠 Estrutura do projeto

- `Usuario`: entidade que representa o usuário do sistema.
- `Conta`: entidade vinculada a um usuário, contendo saldo.
- `Transacao`: operações financeiras entre contas.
- `Command`: camada de escrita (criação de dados).
- `Query`: camada de leitura (consultas e relatórios).

## 🔐 Autenticação

O sistema utiliza JWT para autenticação. Após login, o token deve ser enviado no header:
