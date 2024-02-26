/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

import java.util.Objects;

/**
 *
 * @author KEVIN EP
 */
public class CategoriaDTO {
    private String codCategoria;
    private String NombreCategoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public CategoriaDTO(String codCategoria, String NombreCategoria) {
        this.codCategoria = codCategoria;
        this.NombreCategoria = NombreCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    @Override
    public String toString() {
        return NombreCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaDTO other = (CategoriaDTO) obj;
        return Objects.equals(this.codCategoria, other.codCategoria);
    }
}
