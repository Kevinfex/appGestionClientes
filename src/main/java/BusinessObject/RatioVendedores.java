/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.RatioVendedorDAO;
import TransferObject.RatioVendedorDTO;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class RatioVendedores {
    private RatioVendedorDTO dtoRatioVendedor;
    private RatioVendedorDAO daoRatioVendedor;

    public RatioVendedores() {
        daoRatioVendedor = new RatioVendedorDAO();
    }
    
    public List<RatioVendedorDTO> listar(String codEmpleado, String fechaInicio, String fechaFin) {
        if (daoRatioVendedor.buscar(codEmpleado, fechaInicio, fechaFin) != null) {
            List<RatioVendedorDTO> lista = daoRatioVendedor.buscar(codEmpleado, fechaInicio, fechaFin);
            return lista;
        }
        return null;
    }

}
