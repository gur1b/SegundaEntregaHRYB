package edu.coderhouse.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "Factura"
)
public class Factura {
  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  private int id;
  @ManyToOne
  @JoinColumn(
      name = "id_cliente",
      nullable = false
  )
  private Cliente cliente;
  @Column(
      name = "fecha_creacion"
  )
  private LocalDateTime fechaCreacion;
  @Column(
      name = "total"
  )
  private double total;

  public Factura(Cliente cliente, double total) {
    this.cliente = cliente;
    this.total = total;
    this.fechaCreacion = LocalDateTime.now();
  }

  public Factura() {
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public LocalDateTime getFechaCreacion() {
    return this.fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public double getTotal() {
    return this.total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public String toString() {
    int var10000 = this.id;
    return "Factura: {id=" + var10000 + ", cliente=" + (this.cliente != null ? this.cliente.toString() : "N/A") + ", fechaCreacion=" + String.valueOf(this.fechaCreacion) + ", total=" + this.total + "}";
  }
}
