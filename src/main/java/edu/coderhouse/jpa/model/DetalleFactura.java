package edu.coderhouse.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "DETALLE_FACTURA"
)
public class DetalleFactura {
  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  private int id;
  @ManyToOne
  @JoinColumn(
      name = "id_factura",
      nullable = false
  )
  private Factura factura;
  @Column(
      name = "monto"
  )
  private int cantidad;
  @ManyToOne
  @JoinColumn(
      name = "producto_id",
      nullable = false
  )
  private Producto producto;
  @Column(
      name = "precio"
  )
  private double precio;

  public String toString() {
    String var10000 = this.factura.toString();
    return "DETALLE{, factura=" + var10000 + ", monto=" + this.cantidad + ", producto=" + this.producto.toString() + ", precio=" + this.precio + "}";
  }

  public DetalleFactura(Factura factura, int monto, Producto producto, double precio) {
    this.cantidad = monto;
    this.factura = factura;
    this.producto = producto;
    this.precio = precio;
  }

  public DetalleFactura() {
  }

  public Producto getProducto() {
    return this.producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public Factura getRecibo() {
    return this.factura;
  }

  public void setRecibo(Factura recibo) {
    this.factura = recibo;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecio() {
    return this.precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}
