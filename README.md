# Agenda de Horários

Projeto de portfólio em Java com Spring Boot para gerenciamento de agendamentos.

##  Funcionalidades
- Cadastro de agendamentos
- Verificação de conflitos de horário
- Exclusão de agendamentos por cliente e horário

##  Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- Lombok
- Maven

##  Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/kdusilva/agenda-horarios.git

Entre na pasta do projeto:

cd agenda-horarios

Compile e rode:

./mvnw spring-boot:run

 Estrutura- entity/Agendamento.java → Entidade principal
- repository/AgendamentoRepository.java → Repositório JPA
- service/AgendamentosService.java → Regras de negócio
- controller/AgendamentosController.java (em breve) → Endpoints REST
