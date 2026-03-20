package com.eduardo.agenda_horarios.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.eduardo.agenda_horarios.infrastructure.entity.Agendamento;
import com.eduardo.agenda_horarios.infrastructure.repository.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentosService {
    
    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        
        LocalDateTime inicio = agendamento.getDataHoraAgendamento();
        LocalDateTime fim = inicio.plusHours(1);

        // Verifica se já existe um agendamento para o mesmo serviço nesse intervalo
        Agendamento existente = agendamentoRepository
            .findByServicoAndDataHoraAgendamentoBetween(
                agendamento.getServico(),
                inicio,
                fim
            );

        if (existente != null) {
            throw new RuntimeException("Já existe um agendamento para este serviço nesse horário!");
        }

        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }
}
