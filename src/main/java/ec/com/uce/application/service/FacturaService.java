package ec.com.uce.application.service;

import ec.com.uce.domain.model.Factura;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped

public class FacturaService {

    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    public void guardar (Factura factura){
        //this.facturaRepositoryImpl.persist(factura);
        factura.persist();

    }
    public Factura buscarPorId(Integer id){
        //return this.facturaRepositoryImpl.findById(id);
        return Factura.findById(id);
    }

}
