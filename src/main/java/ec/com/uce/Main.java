package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.AnimacionService;
import ec.com.uce.application.service.FacturaService;
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
        private AnimacionService animacionService
        ;
        @Override
        public int run(String... args) throws Exception {

            String nombreHilo = Thread.currentThread().getName();
            System.out.println("*************************************************");
            System.out.println("nombre del hilo Main: " + nombreHilo);
            System.out.println("ID:" + Thread.currentThread().threadId());
            System.out.println("*************************************************\n");
            
            Animacion proyecto = new Animacion();
            proyecto.setTitulo("Cortometraje Espacial");
            proyecto.setEstudio("Quito Labs Animation");
            this.animacionService.guardar(proyecto);

            System.out.println("\n--- INICIANDO ANIMACIÓN ---");
            this.animacionService.procesarGuion();
            this.animacionService.crearModelos3D();
            this.animacionService.aplicarTexturas();
            this.animacionService.generarRender();

            return 0;
        }

    }


}
