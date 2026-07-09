package ec.com.uce.application.service;


import java.util.List;

import ec.com.uce.domain.model.Reporte;
import ec.com.uce.domain.respository.Auditar;
import ec.com.uce.domain.respository.MedirTiempo;
import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

     @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    //@MedirTiempo
    public void guardar (Reporte reporte){
        String nombreHilo =Thread.currentThread().getName();
             System.out.println("nombre del hilo Reporte: "+ nombreHilo);
             
             try {
                Thread.sleep(3000);
             } catch (Exception e) {
                // TODO: handle exception
             }
        this.reporteRepositoryImpl.persist(reporte);
        

    }
    @Auditar
    public void guardarListaReportes ( List< Reporte> lista){
        for (Reporte p : lista){
            this.guardar(p);
        }
        
    }
    
    public Reporte buscarPorId(Integer id){
        return this.reporteRepositoryImpl.findById(id);
        
    }



}
