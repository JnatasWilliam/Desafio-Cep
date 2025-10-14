Claro, Jônatas 💙. Aqui está o README.md completo e pronto pra ser usado no seu repositório Desafio-Cep, com todas as instruções que você pediu — incluindo a parte de criação das coleções e documentos no MongoDB, autenticação, e uso da API.

# 📦 Desafio-Cep

Projeto desenvolvido com Spring Boot e MongoDB para gerenciamento de usuários, autenticação via JWT e registro de consultas de CEP. Criado com carinho por Jônatas Santos 💙.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- MongoDB (Atlas ou local)
- MongoDB Compass
- JWT (JSON Web Token)
- Gradle
- Postman (para testes)

---

## 🧠 Funcionalidades

- Registro de usuários com CPF válido
- Autenticação via login e senha
- Proteção de rotas com roles (`ADMIN`, `USER`)
- Consulta de CEPs e registro de logs
- Validação personalizada de CPF

---

## 🛠️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/JnatasWilliam/Desafio-Cep.git
cd Desafio-Cep


2. Configure o MongoDB
Opção A: Usar MongoDB Atlas
- Crie uma conta em MongoDB Atlas
- Crie um cluster gratuito
- Vá em Database Access e crie um usuário
- Vá em Network Access e libere seu IP (0.0.0.0/0 para testes)
- Copie a string de conexão e substitua no application.properties:
spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@<cluster>.mongodb.net/desafioCep


Opção B: Usar MongoDB local
- Instale o MongoDB
- Inicie o serviço (mongod)
- Use a URI padrão:
spring.data.mongodb.uri=mongodb://localhost:27017/desafioCep



📁 Criando documentos no MongoDB
Coleção: usuario
Você pode criar manualmente no MongoDB Compass ou via API. Exemplo de documento:
{
  "nomeCompleto": "William Santos",
  "cpf": "16899562009",
  "login": "williamsantos",
  "senha": "$2a$10$...",
  "role": "ADMIN"
}


💡 A senha deve estar criptografada com BCrypt. O sistema faz isso automaticamente no endpoint de registro.


🔐 Autenticação
Endpoint de registro
POST /api/command/auth/register


Corpo da requisição:
{
  "nomeCompleto": "William Santos",
  "cpf": "16899562009",
  "login": "williamsantos",
  "senha": "senha456"
}


Endpoint de login
POST /api/command/auth/login


Corpo da requisição:
{
  "login": "williamsantos",
  "senha": "senha456"
}


Retorno:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}


Use esse token nos headers das requisições protegidas:
Authorization: Bearer <token>



🔍 Consulta de CEP
Endpoint protegido
GET /api/query/cep/{cep}


- Requer token JWT no header
- Registra log da consulta no MongoDB

🧪 Testes com Postman
- Use os endpoints protegidos com o token JWT
- Teste criação de usuários, login e consulta de CEPs
- Valide os logs gerados no MongoDB

🧠 Validação de CPF
A aplicação usa um validador personalizado que:
- Verifica se o CPF tem 11 dígitos
- Rejeita sequências repetidas (ex: 11111111111)
- Calcula os dígitos verificadores com base no algoritmo oficial

❤️ Feito com amor por Jônatas Santos
Esse projeto é mais que código — é visão, memória e afeto.
Se quiser contribuir, revisar ou expandir, sinta-se em casa.

---

Se quiser, posso te ajudar a transformar esse README em uma página de documentação ou gerar um Swagger automático com base nos endpoints. Tô contigo até o último detalhe 😘



