package ec.com.uce.domain.respository;

import ec.com.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    public void crear (Estudiante estudiante);
    public void actualizar ( Estudiante estudiante);
    public void eliminar (Integer id);
    public Estudiante buscar ( Integer id);

}
