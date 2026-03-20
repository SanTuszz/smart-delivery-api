package com.douglassantos.smartdelivery.service;

import com.douglassantos.smartdelivery.exception.RecursoNaoEncontradoException;
import com.douglassantos.smartdelivery.model.Entregador;
import com.douglassantos.smartdelivery.repository.EntregadorRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EntregadorService {

    private final EntregadorRepository repository;

    public EntregadorService(EntregadorRepository repository) {
        this.repository = repository;
    }

    public List<Entregador> listarTodos() {
        return repository.findAll();
    }

    public Entregador salvar(Entregador entregador) {
        return repository.save(entregador);
    }

    public Entregador escolherMelhor(double lat, double lon) {
        return repository.findAll().stream()
                .filter(e -> e.getDisponivel())
                .min(Comparator.comparingDouble(e ->
                        Math.sqrt(Math.pow(e.getLatitude() - lat, 2) +
                                Math.pow(e.getLongitude() - lon, 2))
                ))
                .orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum entregador disponível"));
    }
}