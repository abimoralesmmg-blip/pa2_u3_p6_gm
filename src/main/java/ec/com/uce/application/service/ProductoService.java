package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.domain.model.Producto;
import ec.com.uce.domain.respository.Auditar;
import ec.com.uce.infraestructure.repository.ProductoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductoService {

    @Inject
    private ProductoRepositoryImpl productoRepository;

    @Transactional
    @Auditar
    public void guardarListaSecuencial(List<Producto> lista) {
        for (Producto p : lista) {
            productoRepository.persist(p);
        }
    }

    @Auditar
    public void guardarListaParalela(List<Producto> lista) {
        lista.parallelStream().forEach(this::persistirIndividual);
    }

    @Transactional
    public void persistirIndividual(Producto p) {
        productoRepository.persist(p);
    }
}
