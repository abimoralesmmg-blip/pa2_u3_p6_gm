package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoRepositoryImpl implements PanacheRepositoryBase <Producto, Integer>{

}
