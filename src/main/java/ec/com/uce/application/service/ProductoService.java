package ec.com.uce.application.service;

import ec.com.uce.domain.model.Producto;
import ec.com.uce.domain.respository.Auditar;
import ec.com.uce.infraestructure.repository.ProductoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoService {

    @Inject
    private ProductoRepositoryImpl productoRepository;

    @Auditar
    public void guardar(Producto producto) {
        try {
            Thread.sleep(10); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        productoRepository.persist(producto);
    }

     @Auditar
    public void guardarLista(java.util.List<Producto> lista) {
        for (Producto p : lista) {
            guardar(p);  
        }
    }
}
