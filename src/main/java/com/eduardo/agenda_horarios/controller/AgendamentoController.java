package com.eduardo.agenda_horarios.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.agenda_horarios.infrastructure.entity.Agendamento;
import com.eduardo.agenda_horarios.service.AgendamentosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agendamentos") // Define a rota base da API
@RequiredArgsConstructor
public class AgendamentoController {
    
    private final AgendamentosService agendamentoService;

    // Endpoint para criar um novo agendamento
    @PostMapping
    public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento) {
        Agendamento salvo = agendamentoService.salvarAgendamento(agendamento);
        return ResponseEntity.ok(salvo);
    }

    // Endpoint para deletar um agendamento por cliente e horário
    @DeleteMapping
    public ResponseEntity<Void> deletar(
            @RequestParam LocalDateTime dataHoraAgendamento,
            @RequestParam String cliente) {
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para listar todos os agendamentos de um cliente
    @GetMapping("/cliente/{cliente}")
    public ResponseEntity<List<Agendamento>> listarPorCliente(@PathVariable String cliente) {
        List<Agendamento> lista = agendamentoService.listarAgendamentosPorCliente(cliente);
        return ResponseEntity.ok(lista);
    }

    // Endpoint para listar todos os agendamentos por status (PENDENTE ou CONCLUIDO)
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Agendamento>> listarPorStatus(@PathVariable String status) {
        List<Agendamento> lista = agendamentoService.listarAgendamentosPorStatus(status);
        return ResponseEntity.ok(lista);
    }

    // Endpoint para listar agendamentos de um cliente filtrando por status
    @GetMapping("/cliente/{cliente}/status/{status}")
    public ResponseEntity<List<Agendamento>> listarPorClienteEStatus(
            @PathVariable String cliente,
            @PathVariable String status) {
        List<Agendamento> lista = agendamentoService.listarAgendamentosPorClienteEStatus(cliente, status);
        return ResponseEntity.ok(lista);
    }
}

