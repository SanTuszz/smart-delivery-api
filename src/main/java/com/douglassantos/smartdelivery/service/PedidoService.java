package com.douglassantos.smartdelivery.service;

import com.douglassantos.smartdelivery.model.Entregador;
import com.douglassantos.smartdelivery.model.Pedido;
import com.douglassantos.smartdelivery.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final EntregadorService entregadorService;

    public PedidoService(PedidoRepository pedidoRepository,
                         EntregadorService entregadorService) {
        this.pedidoRepository = pedidoRepository;
        this.entregadorService = entregadorService;
    }

    public Pedido criarPedido(Pedido pedido) {

        Entregador melhor = entregadorService.escolherMelhor(
                pedido.getLatitude(),
                pedido.getLongitude()
        );

        pedido.setEntregador(melhor);
        pedido.setStatus("EM_ENTREGA");

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }
}