package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.AnimacionService;
import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.FacturaServiceCompletableFuture;
import ec.com.uce.application.service.FacturaServiceParalelo;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Animacion;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main (String...arg){

        Quarkus.run(App.class,arg);
    }

    public static class App implements QuarkusApplication {


       @Inject
        private FacturaServiceCompletableFuture facturaServiceCompletableFuture;
        
        @Override
        public int run(String... args) throws Exception {

            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Main: " + nombreHilo);
            System.out.println("ID:" + Thread.currentThread().threadId());

            Factura f1= new Factura();
            f1.setFecha(LocalDate.of(2026, 06, 12));
            f1.setNumero("003-22");
            f1.setRuc("154541313");

            this.facturaServiceCompletableFuture.guardar(f1);

            return 0;
        }

    }


}
