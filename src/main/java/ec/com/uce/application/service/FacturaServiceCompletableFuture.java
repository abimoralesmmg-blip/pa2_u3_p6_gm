package ec.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

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
public class FacturaServiceCompletableFuture {

     @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

     @Inject
    private ReporteService reporteService;
    
    @Inject
    private MailService mailService;

    @MedirTiempo
    public void guardar (Factura factura){

        String nombreHilo =Thread.currentThread().getName();
        System.out.println("nombre del hilo Factura: "+ nombreHilo);
        System.out.println("ID:"+ Thread.currentThread().threadId());

        this.facturaRepositoryImpl.persist(factura);

        //tarea 1
        Reporte repo = new Reporte();
        repo.setTitulo("Importante");
        repo.setAutor("Genessis Molina Morales");
        repo.setTipo("Texto");
        repo.setContenedor("Entrega importamte");

        // completableFuture
        CompletableFuture <Void> completableReporte = CompletableFuture.runAsync(()->this.reporteService.guardar(repo));


        //tarea 1
        Mail mail = new Mail();
        mail.setCorreo("gamolinam@uce");
        mail.setRemitente("ErikaMolina");
        mail.setAsunto("Urgencia");
        mail.setFecha(LocalDate.now());

        CompletableFuture <Void> completableMail = CompletableFuture.runAsync(()-> this.mailService.guardar(mail));

        //finalizar tarea
        CompletableFuture.allOf(completableReporte, completableMail).join();
       
    }

}
