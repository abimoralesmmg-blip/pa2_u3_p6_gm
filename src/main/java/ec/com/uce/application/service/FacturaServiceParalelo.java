package ec.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.domain.respository.MedirTiempo;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class FacturaServiceParalelo {
    
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    @Inject
    private MailService mailService;

    @Inject
    private ReporteService reporteService;

   
    

    @MedirTiempo
    public void guardar(Factura factura) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo Factura: " + nombreHilo + " | ID: " + Thread.currentThread().threadId());

        this.facturaRepositoryImpl.persist(factura);

        // Programación en hilos específicos
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // --- TAREA REPORTE ---
        Reporte repo = new Reporte();
        repo.setTitulo("Importante");
        repo.setAutor("Genessis Molina Morales");
        repo.setTipo("Texto");
        repo.setContenedor("Entrega importante");

        // Hilo especifico
        ReporteServiceTarea reporteTarea = new ReporteServiceTarea(repo, reporteService );
        // ejecutamos el hilo
        executorService.submit(reporteTarea);

        // --- TAREA MAIL ---
        Mail mail = new Mail();
        mail.setCorreo("gamolinam@uce");
        mail.setRemitente("ErikaMolina");
        mail.setAsunto("Urgencia");
        mail.setFecha(LocalDate.now());

        //hilo especifico
        MailServiceTarea mTarea = new MailServiceTarea(mail, mailService);
        executorService.submit(mTarea);

        // Cerrar el proceso de ejecución
        executorService.shutdown();
 
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
    }
}