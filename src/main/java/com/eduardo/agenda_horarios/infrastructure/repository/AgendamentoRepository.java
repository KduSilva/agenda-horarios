package com.eduardo.agenda_horarios.infrastructure.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.agenda_horarios.infrastructure.entity.Agendamento;

import jakarta.transaction.Transactional;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Retorna um agendamento pelo serviço dentro de um intervalo de datas
    Agendamento findByServicoAndDataHoraAgendamentoBetween(
        String servico,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFinal
    );
 
    // Exclui um agendamento pelo horário e cliente
    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);
}
