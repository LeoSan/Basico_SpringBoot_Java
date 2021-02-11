package com.platzi.marken.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompraProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    /*Getter*/
    public Integer getIdCompra() {
        return idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }
    /*Setter*/
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

}
