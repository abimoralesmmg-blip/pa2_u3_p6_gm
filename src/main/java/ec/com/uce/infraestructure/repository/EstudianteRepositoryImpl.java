package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.respository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante);
    }

    @Override
    public Estudiante buscar( Integer id) {
        return this.em.find(Estudiante.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.buscar(id));
    }

    

}
