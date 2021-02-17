package com.platzi.marken.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private  CompraProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;



    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;



    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    /*Getter*/

    public CompraProductoPK getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public boolean isEstado() {
        return estado;
    }


    /*Setter*/

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}
