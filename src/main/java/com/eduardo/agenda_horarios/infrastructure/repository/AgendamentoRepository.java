package com.eduardo.agenda_horarios.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.agenda_horarios.infrastructure.entity.Agendamento;

import jakarta.transaction.Transactional;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Busca por serviço dentro de intervalo de datas
    Agendamento findByServicoAndDataHoraAgendamentoBetween(
        String servico,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFinal
    );

    // Exclui por horário e cliente
    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(
        LocalDateTime dataHoraAgendamento,
        String cliente
    );

    // Busca todos os agendamentos de um cliente
    List<Agendamento> findByCliente(String cliente);

    // Busca todos os agendamentos com status específico
    List<Agendamento> findByStatus(String status);

    // Busca todos os agendamentos de um cliente filtrando por status
    List<Agendamento> findByClienteAndStatus(String cliente, String status);
}