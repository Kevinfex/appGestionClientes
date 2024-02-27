/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.VisitaDAO;
import TransferObject.VisitaDTO;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class Visita {
    private VisitaDAO visitaDAO;
    private VisitaDTO visitaDTO;
    
    public Visita() {
        visitaDAO = new VisitaDAO();
    }
    
    public List<VisitaDTO>listarVisita(){
        if(visitaDAO.listarVisita()!=null){
            List<VisitaDTO>lista = visitaDAO.listarVisita();
            return lista;
        }
        return null;
    }
}
