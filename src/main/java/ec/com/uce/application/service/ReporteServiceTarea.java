package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class ReporteServiceTarea implements Runnable {

    @Inject
    private ReporteService reporteService;
    private Reporte reporte;

    // setters
    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }



    @Override
    public void run() {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Factura: " + nombreHilo + " | ID: " + Thread.currentThread().threadId());
            this.reporteService.guardar(reporte);
          
    }
}