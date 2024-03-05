/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author Bryam
 */
public class VisitaPedidoDTO {
    private Integer codigopedido;
    private String numeroserie;
    private String producto;
    private Float precio;
    private Integer cantidad;
    private Float importe;

    public VisitaPedidoDTO() {
    }

    public VisitaPedidoDTO(Integer codigopedido) {
        this.codigopedido = codigopedido;
    }

    public VisitaPedidoDTO(Integer codigopedido, String numeroserie, String producto, Float precio, Integer cantidad, Float importe) {
        this.codigopedido = codigopedido;
        this.numeroserie = numeroserie;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public Integer getCodigopedido() {
        return codigopedido;
    }

    public void setCodigopedido(Integer codigopedido) {
        this.codigopedido = codigopedido;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    

    
    
    
}
