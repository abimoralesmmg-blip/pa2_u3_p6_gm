package ec.com.uce.application.service;

import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Reporte;

import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

     @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    public void guardar (Reporte reporte){
        //this.reporteRepositoryImpl.persist(factura);
        reporte.persist();

    }
    public Reporte buscarPorId(Integer id){
        //return this.reporteRepositoryImpl.findById(id);
        return Reporte.findById(id);
    }


}
