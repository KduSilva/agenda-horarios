# Agenda de Horários

Projeto de portfólio em Java com Spring Boot para gerenciamento de agendamentos.

##  Funcionalidades
- Cadastro de agendamentos com verificação de conflitos de horário
- Exclusão de agendamentos por cliente e horário
- Consulta de agendamentos por cliente
- Consulta de agendamentos por status (PENDENTE ou CONCLUIDO)
- Consulta de agendamentos por cliente e status
- Endpoints REST em desenvolvimento (Controller)

##  Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- Lombok
- Maven

## Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/kdusilva/agenda-horarios.git

   Entre na pasta do projeto:

   cd agenda-horarios

   - Compile e rode:

   ./mvnw spring-boot:run

   Estrutura- entity/Agendamento.java → Entidade principal
- repository/AgendamentoRepository.java → Repositório JPA com consultas personalizadas
- service/AgendamentosService.java → Regras de negócio e validações
- controller/AgendamentoController.java → Endpoints REST (em construção)
  Esse projeto faz parte do meu portfólio em Java e será expandido com novos recursos.
