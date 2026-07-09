package ec.com.uce.application.service;

import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.respository.Archivo;
import ec.com.uce.domain.respository.Auditar;
import ec.com.uce.infraestructure.repository.EstudianteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteService {

    @Inject
    private EstudianteRepositoryImpl estudianteRepositoryImpl;

    @Auditar
    @Archivo
    public void crear (Estudiante estudiante){

        this.estudianteRepositoryImpl.crear(estudiante);
    }

    @Auditar
    public void  actualizar (Estudiante estudiante){

        this.estudianteRepositoryImpl.actualizar(estudiante);
    }

    @Auditar
    public void eliminar (Integer id){

        this.estudianteRepositoryImpl.eliminar(id);
    }
}
