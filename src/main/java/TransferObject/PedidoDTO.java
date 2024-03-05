/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author Bryam
 */
public class PedidoDTO {
    private Integer codPedido;
    private String numeroserie;
    private String codvisita;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public PedidoDTO(Integer codPedido, String numeroserie, String codvisita) {
        this.codPedido = codPedido;
        this.numeroserie = numeroserie;
        this.codvisita = codvisita;
    }

    public Integer getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getCodvisita() {
        return codvisita;
    }

    public void setCodvisita(String codvisita) {
        this.codvisita = codvisita;
    }
    
    
}
