package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Animacion;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class AnimacionRepositoryImpl implements PanacheRepositoryBase<Animacion, Integer> {
    
    
}