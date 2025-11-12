# SkillUpAI – O Futuro do Trabalho (Global Solution 2025)

## Contexto
O projeto SkillUpAI é uma plataforma RESTful voltada para Upskilling e Reskilling profissional, ajudando pessoas a se prepararem para as carreiras do futuro (2030+).

O sistema oferece recursos de cadastro de usuários, trilhas de aprendizagem e matrículas, permitindo que profissionais desenvolvam competências técnicas e humanas conectadas ao futuro do trabalho.

Este projeto se conecta diretamente aos Objetivos de Desenvolvimento Sustentável (ODS) 4, 8, 9 e 10, promovendo educação de qualidade, trabalho digno, inovação e redução das desigualdades.

## Tecnologias Utilizadas
- Java 17  
- Spring Boot 3.x  
- Maven  
- Spring Data JPA  
- H2 Database (banco em memória)  
- Bean Validation (Jakarta Validation)

## Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/seuusuario/skillupai.git
cd skillupai
```

### 2. Instalar dependências e compilar
```bash
mvn clean install
```

### 3. Executar o projeto
```bash
mvn spring-boot:run
```
A aplicação será iniciada em:  
http://localhost:8080

## Endpoints da API

### Usuários
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/usuarios` | Lista todos os usuários |
| GET | `/usuarios/{id}` | Busca um usuário por ID |
| POST | `/usuarios` | Cria um novo usuário |
| PUT | `/usuarios/{id}` | Atualiza um usuário existente |
| DELETE | `/usuarios/{id}` | Remove um usuário |

### Trilhas de Aprendizagem
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/trilhas` | Lista todas as trilhas |
| GET | `/trilhas/{id}` | Busca uma trilha por ID |
| POST | `/trilhas` | Cria uma nova trilha |
| PUT | `/trilhas/{id}` | Atualiza uma trilha existente |
| DELETE | `/trilhas/{id}` | Remove uma trilha |

### Matrículas
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/matriculas` | Lista todas as matrículas |
| POST | `/matriculas?usuarioId={idUsuario}&trilhaId={idTrilha}` | Matricula um usuário em uma trilha |
| DELETE | `/matriculas/{id}` | Cancela uma matrícula |

## Banco de Dados
O projeto utiliza o banco de dados em memória H2 para facilitar o desenvolvimento e os testes.

Acesse o console H2 em:
```
http://localhost:8080/h2-console
```

Configuração padrão:
```
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha:
```

Os dados iniciais são carregados automaticamente a partir do arquivo `data.sql`.

## Estrutura do Projeto
```
src/
 ├── main/
 │   ├── java/com/skillupai/
 │   │   ├── controller/       # Camada de controle (API REST)
 │   │   ├── model/            # Entidades JPA
 │   │   ├── repository/       # Repositórios (Spring Data JPA)
 │   │   ├── service/          # Regras de negócio
 │   │   └── exception/        # Exceções personalizadas
 │   └── resources/
 │       ├── application.properties
 │       └── data.sql          # Dados iniciais do banco
 └── test/
```

## Objetivos do Projeto
- Promover o desenvolvimento contínuo de profissionais.  
- Preparar pessoas para as demandas do mercado de trabalho de 2030+.  
- Integrar competências humanas e tecnológicas.  
- Apoiar os Objetivos de Desenvolvimento Sustentável:  
  - ODS 4: Educação de qualidade  
  - ODS 8: Trabalho decente e crescimento econômico  
  - ODS 9: Indústria, inovação e infraestrutura  
  - ODS 10: Redução das desigualdades  

## Autores
- Guilherme Lunghini — RM RM556892  
- Marchel Augusto - RM 99856
