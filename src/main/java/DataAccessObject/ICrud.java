package DataAccessObject;

import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public interface ICrud<T> {
    public boolean agregar(T t);
    public boolean actualizar(T t);
    public boolean eliminar(T t);
    public T buscar(T t);
    public List<T> listar();
}
