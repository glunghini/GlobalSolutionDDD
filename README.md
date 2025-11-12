# SkillUpAI – Plataforma de Upskilling e Reskilling para o Futuro do Trabalho

## 🌍 Contexto

O futuro do trabalho está sendo moldado por tecnologias como IA, automação e análise de dados. Isso cria a necessidade urgente de **requalificação (Reskilling)** e **aperfeiçoamento contínuo (Upskilling)** dos profissionais, preparando-os para as futuras demandas.

A **SkillUpAI** é uma API RESTful desenvolvida em **Java + Spring Boot**, voltada a apoiar essa transformação por meio de trilhas de aprendizado e competências do futuro.

---

## 🎯 Objetivo do Projeto

Criar uma **API RESTful** que permita:

- Cadastrar usuários (profissionais/alunos);
- Consultar e gerenciar trilhas de aprendizagem e competências;
- Matricular usuários em trilhas para desenvolvimento profissional.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database (modo memória)**
- **Maven**
- **Jakarta Validation**
- **Lombok**

---

## 🧩 Arquitetura

Seguindo o padrão **Camada em Três Níveis (DDD Simplificado)**:

Controller → Service → Repository → Model


- **Controller:** expõe endpoints REST.  
- **Service:** contém regras de negócio e validações.  
- **Repository:** abstrai o acesso ao banco via JPA.  
- **Model:** define as entidades persistidas.  

---

## 🗄️ Estrutura do Projeto

src<br>
├── main/<br>
│ ├── java/com/skillupai/<br>
│ │ ├── controller/<br>
│ │ ├── service/<br>
│ │ ├── repository/<br>
│ │ ├── model/<br>
│ │ └── exception/<br>
│ ├── resources/<br>
│ │ ├── application.properties<br>
│ │ └── data.sql


---

## 🧱 Entidades Implementadas

### **Usuário**
- id  
- nome  
- email  
- área de atuação  
- nível de carreira  
- data de cadastro  

### **Trilha**
- id  
- nome  
- descrição  
- nível  
- carga horária  
- foco principal  
- lista de competências  

### **Competência**
- id  
- nome  
- categoria  
- descrição  

### **Matrícula**
- id  
- usuário (ManyToOne)  
- trilha (ManyToOne)  
- data de inscrição  
- status  

---

## ✅ CRUDs Implementados

| Entidade     | Endpoints principais         | Métodos REST suportados |
|---------------|------------------------------|--------------------------|
| Usuário       | `/usuarios`                  | GET, POST, PUT, DELETE   |
| Trilha        | `/trilhas`                   | GET, POST, PUT, DELETE   |
| Competência   | `/competencias`              | GET, POST, PUT, DELETE   |
| Matrícula     | `/matriculas`                | GET, POST, PUT, DELETE   |

---

## 💾 Banco de Dados e Seeds

O banco **H2** é inicializado automaticamente via `schema.sql` e `data.sql`.

### Dados iniciais:
- 2 usuários  
- 2 trilhas  
- 3 competências  
- 2 matrículas  

O `data.sql` também contém ajustes no `AUTO_INCREMENT` para evitar conflitos ao testar os POSTs no Postman.

---

## ⚠️ Validações e Exceções

Foram aplicadas validações com **Jakarta Validation**:
- `@NotBlank`
- `@Email`
- `@Size`
- `@Min`

E tratamento global de erros via `@RestControllerAdvice`, com mensagens legíveis e status HTTP adequados (`400`, `404`, `500`).

---

## 🧪 Testes com Postman

O projeto acompanha uma coleção pronta:  
**SkillUpAI_API_Collection.postman_collection.json**

### Exemplo de Body – POST /usuarios
```json
{
  "nome": "Carla Dias",
  "email": "carla.dias@email.com",
  "areaAtuacao": "Design",
  "nivelCarreira": "Intermediário",
  "dataCadastro": "2025-11-12"
}
```
Exemplo de Body – POST /matriculas
{
  "usuario": { "id": 1 },
  "trilha": { "id": 1 },
  "dataMatricula": "2025-11-12",
  "progresso": 0
}

## ▶️ Execução do Projeto
### Pré-requisitos:
- JDK 17+
- Maven 3.8+
- IntelliJ ou VS Code com suporte Spring Boot

## 📘 Conexão com o Tema Global Solution

### O projeto aborda os seguintes ODS da ONU:
- ODS 4: Educação de Qualidade
- ODS 8: Trabalho Decente e Crescimento Econômico
- ODS 9: Indústria, Inovação e Infraestrutura
- ODS 10: Redução das Desigualdades

A SkillUpAI promove a inclusão e o desenvolvimento profissional por meio de tecnologia e aprendizado contínuo.

## 👥 Equipe

### Integrante	RM	Função

- Guilherme Lunghini RM 556892
- Marchel Augusto RM 99856




