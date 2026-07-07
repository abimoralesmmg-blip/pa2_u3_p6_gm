package ec.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future; // IMPORTANTE IMPORTAR ESTO

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

    @Inject
    private ReporteServiceTarea reporteServiceTarea;

    @Inject
    private MailServiceTarea mailServiceTarea;

    @MedirTiempo
    public void guardar(Factura factura) throws InterruptedException, ExecutionException {

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

        this.reporteServiceTarea.setReporte(repo);

        //ReporteServiceTarea reporteTarea = new ReporteServiceTarea(repo);

        // 1. Disparamos la ejecución y guardamos su "promesa" futura
        Future<?> futureReporte = executorService.submit(reporteServiceTarea);

        // --- TAREA MAIL ---
        Mail mail = new Mail();
        mail.setCorreo("gamolinam@uce");
        mail.setRemitente("ErikaMolina");
        mail.setAsunto("Urgencia");
        mail.setFecha(LocalDate.now());
        this.mailServiceTarea.setMail(mail);

        //MailServiceTarea mTarea = new MailServiceTarea(mail, mailService);


        // 1. Disparamos la ejecución y guardamos su "promesa" futura
        Future<?> futureMail = executorService.submit(mailServiceTarea);


        futureReporte.get();
        futureMail.get();
        
        // 2. Cerramos la recepción de nuevas tareas
        executorService.shutdown();
 
    }
}