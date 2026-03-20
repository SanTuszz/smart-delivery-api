package com.douglassantos.smartdelivery.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double latitude;
    private Double longitude;

    private String status;

    @ManyToOne
    private Entregador entregador;

    // getters e setters
    public Long getId() { return id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getLatitude() { return latitude; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }

    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Entregador getEntregador() { return entregador; }

    public void setEntregador(Entregador entregador) { this.entregador = entregador; }
}