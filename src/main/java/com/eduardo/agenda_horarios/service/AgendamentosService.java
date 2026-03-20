package com.eduardo.agenda_horarios.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardo.agenda_horarios.infrastructure.entity.Agendamento;
import com.eduardo.agenda_horarios.infrastructure.repository.AgendamentoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AgendamentosService {
    
    private final AgendamentoRepository agendamentoRepository;

    // Salva um novo agendamento, verificando se já existe conflito de horário
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

        // Define status inicial como PENDENTE
        agendamento.setStatus("PENDENTE");

        return agendamentoRepository.save(agendamento);
    }

    // Deleta um agendamento pelo horário e cliente
    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }

    // Lista todos os agendamentos de um cliente
    public List<Agendamento> listarAgendamentosPorCliente(String cliente) {
        return agendamentoRepository.findByCliente(cliente);
    }

    // Lista todos os agendamentos com status específico (PENDENTE ou CONCLUIDO)
    public List<Agendamento> listarAgendamentosPorStatus(String status) {
        return agendamentoRepository.findByStatus(status);
    }

    // Lista todos os agendamentos de um cliente filtrando por status
    public List<Agendamento> listarAgendamentosPorClienteEStatus(String cliente, String status) {
        return agendamentoRepository.findByClienteAndStatus(cliente, status);
    }
}
