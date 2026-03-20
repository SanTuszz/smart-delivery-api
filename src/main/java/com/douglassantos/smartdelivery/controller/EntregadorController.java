package com.douglassantos.smartdelivery.controller;

import com.douglassantos.smartdelivery.model.Entregador;
import com.douglassantos.smartdelivery.service.EntregadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorService service;

    public EntregadorController(EntregadorService service) {
        this.service = service;
    }

    // listar todos
    @GetMapping
    public List<Entregador> listar() {
        return service.listarTodos();
    }

    // criar entregador
    @PostMapping
    public Entregador criar(@RequestBody Entregador entregador) {
        return service.salvar(entregador);
    }

    // 🔥 buscar melhor entregador
    @GetMapping("/melhor")
    public Entregador melhor(
            @RequestParam Double lat,
            @RequestParam Double lon) {

        return service.escolherMelhor(lat, lon);
    }
}