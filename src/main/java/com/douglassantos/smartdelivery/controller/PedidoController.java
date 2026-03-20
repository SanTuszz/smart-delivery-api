package com.douglassantos.smartdelivery.controller;

import com.douglassantos.smartdelivery.model.Pedido;
import com.douglassantos.smartdelivery.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // Criar pedido (já escolhe entregador automático)
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }

    // Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }
}