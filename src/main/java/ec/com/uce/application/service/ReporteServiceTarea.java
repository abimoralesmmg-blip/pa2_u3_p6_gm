package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;


public class ReporteServiceTarea implements Runnable {

  
    private ReporteService reporteService;
    private Reporte reporte;

    public ReporteServiceTarea(Reporte reporte, ReporteService reporteService) {
        this.reporte = reporte;
        this.reporteService = reporteService;
    }

    @Override
    public void run() {
        
            this.reporteService.guardar(reporte);
          
    }
}